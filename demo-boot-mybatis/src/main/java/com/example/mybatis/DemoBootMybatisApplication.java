package com.example.mybatis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoBootMybatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoBootMybatisApplication.class, args);
        System.out.println("spring boot 整合mybatis-plus 启动完成");
    }

}
