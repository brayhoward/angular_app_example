package com.gewaukesha.lifecycle.filter;

import com.gewaukesha.lifecycle.service.SeshatService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author <a href="mailto:alexander.rosemann@ge.com">Alexander Rosemann (502550922)</a>
 */
public class SeshatAuthenticationFilter extends AuthenticationFilter {

    private static final Logger logger = LoggerFactory.getLogger(SeshatAuthenticationFilter.class);


    @Autowired
    private SeshatService seshat;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String servletPath = request.getServletPath();
        if (StringUtils.startsWith(servletPath, "/info")
                || StringUtils.startsWith(servletPath, "/health")
                || StringUtils.startsWith(servletPath, "/v2/api-docs")
                || StringUtils.startsWith(servletPath, "/docs")
                || StringUtils.startsWith(servletPath, "/swagger-resources")) {
            filterChain.doFilter(request, response);
            return;
        }
        // check whether the user has been authenticated (cookie vs. header)
        String token = getToken(request, X_SESHAT_TOKEN);

        // do we have a token and a valid session?
        if (StringUtils.isEmpty(token) || !seshat.isValidSession(token)) {
            unauthorized(request, response);
            return;
        }
        // all good - request has a valid session
        filterChain.doFilter(request, response);
    }


}