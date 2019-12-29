package com.example.demo.rocketmq.rest;

import com.example.demo.rocketmq.client.StreamClient;
import com.example.demo.rocketmq.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.*;

/**
 * @author ccubee
 * @since 19-12-29 16:01
 * 通过output 发送消息
 */
@RestController
@RequestMapping
public class StreamRest {

    private final StreamClient streamClient;

    public StreamRest(StreamClient streamClient) {
        this.streamClient = streamClient;
    }

    @PostMapping("sendMsg")
    public void sendMsg(@RequestBody User user){

        streamClient.output1().send(MessageBuilder.withPayload(user).build());
    }
}
