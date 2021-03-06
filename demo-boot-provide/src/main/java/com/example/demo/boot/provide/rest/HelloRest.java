package com.example.demo.boot.provide.rest;

import com.example.demo.boot.commons.fade.HelloClient;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zongkun
 * @creed Talk is cheap,show me the code
 * @since 2019-7-23 17:49
 */
@RestController
public class HelloRest implements HelloClient {


    @Override
    public String hello(String name) {
        System.out.println("1001");
        return "hello: " + name + "!";
    }
}
