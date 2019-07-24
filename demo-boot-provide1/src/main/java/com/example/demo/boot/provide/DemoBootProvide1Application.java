package com.example.demo.boot.provide;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class DemoBootProvide1Application {

    public static void main(String[] args) {
        SpringApplication.run(DemoBootProvide1Application.class, args);
    }

}
