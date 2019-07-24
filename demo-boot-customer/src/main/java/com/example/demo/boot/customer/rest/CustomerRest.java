package com.example.demo.boot.customer.rest;

import com.example.demo.boot.provide.client.HelloClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zongkun
 * @creed Talk is cheap,show me the code
 * @since 2019-7-23 19:48
 */
@RestController
public class CustomerRest {


    @Autowired
    HelloClient helloClient;

    @GetMapping("hello")
    public String hello(String name) {
        return helloClient.hello(name);
    }
}
