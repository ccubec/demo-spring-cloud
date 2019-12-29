package com.example.demo.rocketmq.receive;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.rocketmq.client.StreamClient;
import com.example.demo.rocketmq.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

/**
 * @author ccubee
 * @since 19-12-29 16:05
 */
@Component
@Slf4j
@EnableBinding({StreamClient.class})
public class StreamReceiver {

    @StreamListener("input1")
    public void getMsg(String msg){
        log.info("消息是：-----》" + JSONObject.parseObject(msg, User.class));

    }
}
