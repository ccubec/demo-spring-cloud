package com.example.demo.rocketmq.client;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * @author ccubee
 * @since 19-12-29 15:58
 * 自定义输入输出
 */
public interface StreamClient {

    /**
     * 自定义输入流 对应 yml配置
     * @return
     */
    @Input("input1")
    SubscribableChannel input1();

    /**
     *自定义输出流 对应 yml配置
     * @return
     */
    @Output("output1")
    MessageChannel output1();

}
