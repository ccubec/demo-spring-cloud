package com.example.mybatis.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author zongk
 * @since 19-11-18 21:00
 */
@Data
@TableName("demo_user.t_user")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {

    @TableId(type = IdType.AUTO)
    private Integer id;

    private String wxId;

    private String wxNickname;
    @NotNull
    private String roles;

    private String avatarUrl;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;
}
