package com.gewaukesha.lifecycle.filter;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;

/**
 * @author <a href="mailto:alexander.rosemann@ge.com">Alexander Rosemann (502550922)</a>
 */
abstract class AuthenticationFilter extends OncePerRequestFilter {
    
    private static final Logger logger = LoggerFactory.getLogger(AuthenticationFilter.class);

    public static final String X_SESHAT_TOKEN = "x-seshat-token";

    protected String getToken(HttpServletRequest request, String xSeshatToken) {
        String tokenHeader = request.getHeader(X_SESHAT_TOKEN);
        String tokenCookie = extractCookie(X_SESHAT_TOKEN, request.getCookies()).orElse("");
        logger.debug("{} header value: {}.", X_SESHAT_TOKEN, StringUtils.abbreviateMiddle(tokenHeader, "...", 11));
        logger.debug("{} cookie value: {}.", X_SESHAT_TOKEN, StringUtils.abbreviateMiddle(tokenCookie, "...", 11));
        return StringUtils.isEmpty(tokenHeader) ? tokenCookie : tokenHeader;
    }

    protected void unauthorized(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String method = request.getMethod();
        StringBuffer url = request.getRequestURL();
        logger.warn("Unauthorized {} request to {}.", method, url.toString());
        response.setContentType("application/json");
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Invalid or missing '" + X_SESHAT_TOKEN + "'.");
    }

    private Optional<String> extractCookie(String cookieName, Cookie[] cookies) {
        if (ArrayUtils.isEmpty(cookies)) {
            return Optional.empty();
        }
        return Arrays.stream(cookies)
                .filter(c -> StringUtils.equals(c.getName(), cookieName))
                .map(c -> c.getValue())
                .findFirst();
    }

}
