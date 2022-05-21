package com.matthew.practice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.core.env.ConfigurableEnvironment;

@Slf4j
@SpringBootApplication
@EnableDiscoveryClient
public class PaymentMain9003 {
    public static void main(String[] args) {
        ConfigurableEnvironment env = SpringApplication
                .run(PaymentMain9003.class, args).getEnvironment();
        String port = env.getProperty("server.port", "8080");
        log.info("项目信息 http://localhost:{}", port);
        log.info("二维码 http://localhost:{}/qr_code", port);
    }
}
