package com.example.demo.boot.provide.client;

import com.example.demo.boot.commons.fade.HelloService;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("provide")
public interface HelloClient extends HelloService {
}
