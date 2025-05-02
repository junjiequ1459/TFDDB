package com.junqu.TFDDB.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "nexon.api")
@Data
public class NexonApiProperties {
    private String key;
    private String baseUrl;
}
