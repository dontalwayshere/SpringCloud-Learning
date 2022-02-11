package com.matthew.practice.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationContextConfig {
    @Bean
    //@LoadBalanced //自定义负载均衡需要去掉该注解
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
