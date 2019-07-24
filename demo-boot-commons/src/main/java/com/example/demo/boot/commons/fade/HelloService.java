package com.example.demo.boot.commons.fade;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

public interface HelloService {

    @GetMapping
    String hello(@RequestParam String name);
}
