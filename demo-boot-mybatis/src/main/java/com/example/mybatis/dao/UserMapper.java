package com.example.mybatis.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mybatis.entity.User;
import org.springframework.stereotype.Repository;

/**
 * @author zongk
 * @since 19-11-18 20:59
 */
@Repository
public interface UserMapper extends BaseMapper<User> {
}
