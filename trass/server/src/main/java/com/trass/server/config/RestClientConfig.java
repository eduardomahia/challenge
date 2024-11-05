package com.trass.server.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestClient;

@Configuration
public class RestClientConfig {

    @Value("${restClient.timeoutInMs}")
    private int timeoutInMs;

    @Bean
    public RestClient restClient() {
        final HttpComponentsClientHttpRequestFactory clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory();
        clientHttpRequestFactory.setConnectTimeout(timeoutInMs);
        clientHttpRequestFactory.setConnectionRequestTimeout(timeoutInMs);

        return RestClient.builder().requestFactory(clientHttpRequestFactory).build();
    }
}
