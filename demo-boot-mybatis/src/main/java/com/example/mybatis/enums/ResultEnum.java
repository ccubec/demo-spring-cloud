package com.example.mybatis.enums;

import lombok.Getter;

/**
 * @author zongkun
 * @since 19-9-14
 */
@Getter
public enum ResultEnum {

    SUCCESS(0, "成功"),
    FAILED(1, "失败"),




    ;


    private Integer code;

    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
