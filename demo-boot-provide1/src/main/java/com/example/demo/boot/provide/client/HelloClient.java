package com.example.demo.boot.provide.client;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("provide")
public interface HelloClient extends com.example.demo.boot.commons.fade.HelloClient {
}
