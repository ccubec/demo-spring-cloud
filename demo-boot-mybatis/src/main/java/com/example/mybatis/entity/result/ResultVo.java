package com.example.mybatis.entity.result;

import com.example.mybatis.enums.ResultEnum;
import lombok.Data;

/**
 * @author zongkun
 * @since 19-9-14
 */
@Data
public class ResultVo {

    private Integer code;

    private String msg;

    private Object data;

    public ResultVo(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static ResultVo isOk(){
        return new ResultVo(ResultEnum.SUCCESS.getCode(), ResultEnum.SUCCESS.getMsg(), null);
    }

    public static ResultVo isOk(Object data){
        return new ResultVo(ResultEnum.SUCCESS.getCode(), ResultEnum.SUCCESS.getMsg(), data);
    }

    public static ResultVo isFail(){
        return new ResultVo(ResultEnum.FAILED.getCode(), ResultEnum.FAILED.getMsg(), null);
    }


}
