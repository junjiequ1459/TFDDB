package com.junqu.TFDDB.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {
    @Bean
    public WebClient nexonWebClient(NexonApiProperties props) {
        return WebClient.builder()
                .baseUrl(props.getBaseUrl())
                // Nexon expects this header name
                .defaultHeader("x-nxopen-api-key", props.getKey())
                // Ask for JSON
                .defaultHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }
}
