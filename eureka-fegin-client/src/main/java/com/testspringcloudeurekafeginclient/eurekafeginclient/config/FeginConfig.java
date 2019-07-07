package com.testspringcloudeurekafeginclient.eurekafeginclient.config;

import feign.Feign;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.sql.Time;
import java.util.concurrent.TimeUnit;
@Configuration
public class FeginConfig {


    @Bean
    @Scope("prototype")
    public Feign.Builder feignHystrixBuilder() {
        return Feign.builder();
    }
}
