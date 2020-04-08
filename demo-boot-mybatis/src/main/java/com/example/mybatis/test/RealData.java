package com.example.mybatis.test;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.mybatis.dao.UserMapper;
import com.example.mybatis.entity.User;

import java.util.List;
import java.util.concurrent.Callable;

/**
 * @author ccubee
 * @since 20-4-5 17:23
 */
public class RealData implements Callable<List<User>> {

    private UserMapper userMapper;
    private User user;

    public RealData(User user, UserMapper userMapper) {
        this.user = user;
        this.userMapper = userMapper;
    }

    @Override
    public List<User> call() throws Exception {
        return userMapper.selectList(new QueryWrapper<>(user));
    }
}
