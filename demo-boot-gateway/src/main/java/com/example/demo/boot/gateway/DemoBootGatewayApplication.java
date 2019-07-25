package com.example.demo.boot.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author zongkun
 * @creed Talk is cheap,show me the code
 * @since 2019-7-25 17:16
 */
@SpringBootApplication
@EnableEurekaClient
public class DemoBootGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoBootGatewayApplication.class);
    }
}
