package com.example.demo.boot.commons.fade;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("provide")
public interface HelloClient {

    @GetMapping
    String hello(@RequestParam String name);
}
