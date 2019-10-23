package com.example.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClientConfiguration;

@SpringBootApplication
@RibbonClient(name = "httpbin", configuration = RibbonClientConfiguration.class)
public class GatewayRetryDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(GatewayRetryDemoApplication.class, args);
    }
}
