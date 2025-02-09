package com.bricks.blogsystem.utils;

import com.bricks.blogsystem.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserUntil {
    @Autowired
    private UserMapper userMapper;
    public Boolean userExist(Long id) {
        return userMapper.selectUserById(id) != null;
    }
}
