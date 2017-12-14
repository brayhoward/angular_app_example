package com.gewaukesha.lifecycle;

import java.net.InetSocketAddress;
import java.net.Proxy;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import javax.servlet.Filter;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.gewaukesha.lifecycle.filter.SeshatAuthenticationFilter;

@SpringBootApplication
public class LifeCycleApplication {

	private static final Logger logger = LoggerFactory.getLogger(LifeCycleApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(LifeCycleApplication.class, args);
	}
	
    @Bean
    public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {
        MappingJackson2HttpMessageConverter jsonConverter = new MappingJackson2HttpMessageConverter();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, true);
        jsonConverter.setObjectMapper(objectMapper);
        return jsonConverter;
    }


    //    @Bean
    //    @Order(Ordered.HIGHEST_PRECEDENCE)
    //    public Filter requestLoggingFilter() {
    //        return new SimpleRequestLoggingFilter();
    //    }

    //    @Bean
    //    @Order(Ordered.HIGHEST_PRECEDENCE)
    //    public Filter requestLoggingFilter() {
    //        return new RequestLoggingFilter(Arrays.asList("x-seshat-token"));
    //    }

    @Bean
    public Filter authenticationFilter() {
        return new SeshatAuthenticationFilter();
    }

    @Bean
    @Autowired
    public RestTemplate seshatRestTemplate(RestTemplateBuilder builder,
                                           @Value("${seshat.url:}") String url,
                                           @Value("${proxy.host:}") String proxyDomain,
                                           @Value("${proxy.port:}") Integer proxyPort) {
        builder = builder.rootUri(url);
        return applyProxySettings(builder, proxyDomain, proxyPort).build();
    }


    private RestTemplateBuilder applyProxySettings(RestTemplateBuilder builder, String proxyDomain, Integer proxyPort) {
        if (StringUtils.isNotBlank(proxyDomain)) {
            logger.info("Applying proxy settings {}:{}.", proxyDomain, proxyPort);
            SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
            Proxy httpsProxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(proxyDomain, proxyPort));
            requestFactory.setProxy(httpsProxy);
            return builder.requestFactory(requestFactory);
        }
        return builder;
    }

}
