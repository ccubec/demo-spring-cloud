package com.example.demo.rocketmq.entity;

import lombok.Data;

/**
 * @author ccubee
 * @since 19-12-29 16:02
 */
@Data
public class User {

    private Integer id;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 姓名
     */
    private String name;
}
