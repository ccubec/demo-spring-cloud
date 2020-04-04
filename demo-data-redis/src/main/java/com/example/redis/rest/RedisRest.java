package com.example.redis.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ccubee
 * @since 20-4-2 22:15
 */
@RestController
public class RedisRest {

    @Autowired
    @Qualifier("stringRedisTemplate2")
    StringRedisTemplate stringRedisTemplate;

    @GetMapping("redis")
    public String redis(){
        stringRedisTemplate.opsForValue().set("key","123");
        return stringRedisTemplate.opsForValue().get("key");
    }
}
