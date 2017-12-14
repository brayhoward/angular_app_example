package com.gewaukesha.lifecycle.service;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.gewaukesha.lifecycle.model.seshat.AuthInfo;

/**
 * @author <a href="mailto:alexander.rosemann@ge.com">Alexander Rosemann (502550922)</a>
 */
@Service
public class SeshatService {

    public static final String X_SESHAT_TOKEN = "x-seshat-token";
    public static final String SESHAT_AUTH_ENDPOINT = "/api/auth";
    private static final Logger logger = LoggerFactory.getLogger(SeshatService.class);
    private RestTemplate seshatTemplate;

    @Autowired
    public SeshatService(@Qualifier("seshatRestTemplate") RestTemplate seshatTemplate) {
        this.seshatTemplate = seshatTemplate;
    }

    //@Cacheable("user_cache")
    public boolean isValidSession(String seshatToken) {
        long start = System.currentTimeMillis();
        if (StringUtils.isBlank(seshatToken)) {
            return false;
        }
        boolean status = false;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        headers.set(X_SESHAT_TOKEN, seshatToken);
        HttpEntity<String> entity = new HttpEntity<>(headers);
        try {
            ResponseEntity<AuthInfo> resp = seshatTemplate.exchange(SESHAT_AUTH_ENDPOINT, HttpMethod.GET, entity, AuthInfo.class);
            status = resp.getStatusCode() == HttpStatus.OK;
        } catch (HttpClientErrorException ignored) {
        }
        long end = System.currentTimeMillis();
        logger.debug("done checking provided session. is session valid? {}. Time to check auth: {}ms.", status, end - start);
        return status;
    }

}
