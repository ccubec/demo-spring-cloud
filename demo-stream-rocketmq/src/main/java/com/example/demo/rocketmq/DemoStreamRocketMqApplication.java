package com.example.demo.rocketmq;

import com.example.demo.rocketmq.client.StreamClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

/**
 * @since  2019 12 29 15点53分
 * @author lolka
 */
@SpringBootApplication
@EnableBinding({StreamClient.class})
public class DemoStreamRocketMqApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoStreamRocketMqApplication.class, args);
        System.out.println("rocket mq 启动完成------------------》");
    }

}
