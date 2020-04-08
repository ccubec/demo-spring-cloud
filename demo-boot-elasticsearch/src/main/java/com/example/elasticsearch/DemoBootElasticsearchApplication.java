package com.example.elasticsearch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@SpringBootApplication
@EnableElasticsearchRepositories("com.example.elasticsearch.dao")
public class DemoBootElasticsearchApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoBootElasticsearchApplication.class, args);
        System.out.println("elasticsearch启动成功");
    }

}
