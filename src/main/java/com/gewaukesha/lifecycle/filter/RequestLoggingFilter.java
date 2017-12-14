package com.gewaukesha.lifecycle.filter;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.Assert;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;
import org.springframework.web.util.WebUtils;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

/**
 * @author <a href="mailto:alexander.rosemann@ge.com">Alexander Rosemann (502550922)</a>
 * @since 2.5.0
 */
public class RequestLoggingFilter extends OncePerRequestFilter {

    private static final Logger logger = LoggerFactory.getLogger(RequestLoggingFilter.class);

    private static final int MAX_PAYLOAD_SIZE = 1024;

    @Value("${request-logging.enabled:false}")
    private boolean enabled;

    private List<String> headerNameWhiteList = Arrays.asList("content-type", "host");
    private List<String> abbreviateHeaders;
    private String urlPattern;

    public RequestLoggingFilter() {
        this.urlPattern = ".*";
        this.headerNameWhiteList = null;
        this.abbreviateHeaders = null;
    }

    public RequestLoggingFilter(List<String> obfuscateHeaders) {
        Assert.notNull(obfuscateHeaders, "Parameter 'abbreviateHeaders' must not be null.");
        this.abbreviateHeaders = obfuscateHeaders;
        this.headerNameWhiteList = null;
        this.urlPattern = ".*";
    }

    public RequestLoggingFilter(String urlPattern, List<String> headerNames) {
        Assert.notNull(urlPattern, "Parameter 'urlPattern' must not be null.");
        this.urlPattern = urlPattern;
        this.headerNameWhiteList = headerNames;
        this.abbreviateHeaders = null;
    }


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        if (!enabled) {
            filterChain.doFilter(request, response);
            return;
        }

        long start = System.currentTimeMillis();

        // cache request/response for logging
        ContentCachingRequestWrapper wrappedRequest = new ContentCachingRequestWrapper(request);
        ContentCachingResponseWrapper wrappedResponse = new ContentCachingResponseWrapper(response);
        String requestUrl = getRequestUrl(wrappedRequest);

        // process filter chain
        try {
            filterChain.doFilter(wrappedRequest, wrappedResponse);
        } catch (Throwable e) {
            logger.error("Failed to process the filter chain.", e);
            final StringBuilder log = new StringBuilder();
            final long end = System.currentTimeMillis();
            log.append(logRequest(wrappedRequest, wrappedResponse.getStatusCode(), end - start));
            logger.debug(log.toString());
            throw e;
        }

        // do the logging
        if (requestUrl.matches(urlPattern) && logger.isDebugEnabled()) {
            final StringBuilder log = new StringBuilder();
            final long end = System.currentTimeMillis();
            log.append(logRequest(wrappedRequest, wrappedResponse.getStatusCode(), end - start));
            log.append(logResponse(wrappedResponse));
            logger.debug(log.toString());
        }
        wrappedResponse.copyBodyToResponse();

    }

    private String getRequestUrl(HttpServletRequest wrappedRequest) {
        return (wrappedRequest != null && wrappedRequest.getRequestURL() != null)
                ? wrappedRequest.getRequestURL().toString() : "";
    }

    private String logRequest(HttpServletRequest wrappedRequest, int httpStatusCode, long duration) {
        StringBuilder sb = new StringBuilder();
        final String reqSessionId = StringUtils.defaultIfBlank(wrappedRequest.getRequestedSessionId(), "NA");

        // method - sessionId - host - url - duration in ms - status code
        sb.append(String.format("%d - %s - %s - %s - %s - %dms", httpStatusCode, wrappedRequest.getMethod(),
                reqSessionId, wrappedRequest.getRemoteAddr(), wrappedRequest.getRequestURL().toString(), duration));
        logRequestHeader(wrappedRequest, sb);
        if (isHttpRequestMethod(wrappedRequest, "post")) {
            sb.append(logPostRequestBody(wrappedRequest));
        } else if (isHttpRequestMethod(wrappedRequest, "get")) {
            sb.append(logGetRequestMethod(wrappedRequest));
        }
        return sb.toString();
    }

    private boolean isHttpRequestMethod(HttpServletRequest request, String httpMethod) {
        return StringUtils.equalsIgnoreCase(request.getMethod(), httpMethod);
    }

    private String logGetRequestMethod(HttpServletRequest req) {
        StringBuilder sb = new StringBuilder();
        if (req.getParameterNames() != null && req.getParameterNames().hasMoreElements()) {
            sb.append(String.format("\n\tParameters: "));
            Enumeration<String> parameterNames = req.getParameterNames();
            while (parameterNames.hasMoreElements()) {
                String name = parameterNames.nextElement();
                sb.append(String.format("%s=%s; ", name, req.getParameter(name)));
            }
        }
        return sb.toString();
    }

    private String logPostRequestBody(final HttpServletRequest req) {
        final StringBuilder sb = new StringBuilder();
        ContentCachingRequestWrapper wrapper = WebUtils.getNativeRequest(req, ContentCachingRequestWrapper.class);
        if (wrapper != null) {
            byte[] buf = wrapper.getContentAsByteArray();
            sb.append(logPayload(buf, wrapper.getCharacterEncoding(), "Request"));
        }
        return sb.toString();
    }

    private String logResponse(final HttpServletResponse resp) throws IOException {
        final StringBuilder sb = new StringBuilder();
        ContentCachingResponseWrapper wrapper = WebUtils.getNativeResponse(resp, ContentCachingResponseWrapper.class);
        if (wrapper != null) {
            byte[] buf = wrapper.getContentAsByteArray();
            sb.append(logPayload(buf, wrapper.getCharacterEncoding(), "Response"));
        }
        return sb.toString();
    }

    private String logPayload(byte[] buf, String encoding, String label) {
        final StringBuilder sb = new StringBuilder();
        sb.append("\n\t").append(label).append(": ");
        if (buf.length > 0) {
            int length = Math.min(buf.length, MAX_PAYLOAD_SIZE);
            String payload;
            try {
                payload = new String(buf, 0, length, encoding);
            } catch (UnsupportedEncodingException ex) {
                payload = "[unknown]";
            }
            sb.append(payload.replace("\r\n", " ").replace("\n", " "));
        }
        return sb.toString();
    }

    private void logRequestHeader(HttpServletRequest req, StringBuilder requestDetail) {
        requestDetail.append("\n\tHeaders: ");
        Collections.list(req.getHeaderNames()).stream()
                .filter(h -> logThisHeader(h))
                .forEach(h -> {
                            String headerValue = abbreviateThisHeader(h) ? StringUtils.abbreviateMiddle(req.getHeader(h), "...", 16) : req.getHeader(h);
                            requestDetail.append(String.format("%s=%s; ", h, headerValue));
                        }
                );
    }

    private boolean logThisHeader(String header) {
        if (CollectionUtils.isEmpty(headerNameWhiteList)) {
            return true;
        }
        return CollectionUtils.exists(headerNameWhiteList, w -> StringUtils.equalsIgnoreCase((String) w, header));
    }

    private boolean abbreviateThisHeader(String header) {
        if (CollectionUtils.isEmpty(abbreviateHeaders)) {
            return false;
        }
        return CollectionUtils.exists(abbreviateHeaders, w -> StringUtils.equalsIgnoreCase((String) w, header));
    }

}