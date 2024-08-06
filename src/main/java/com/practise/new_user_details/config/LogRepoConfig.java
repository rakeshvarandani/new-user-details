package com.practise.new_user_details.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class LogRepoConfig {

    @Value("${logService.base.url}")
    private String logBaseUrl;

    @Bean
    public WebClient webClient() {
        return WebClient.builder().baseUrl(logBaseUrl).build();
    }

}
