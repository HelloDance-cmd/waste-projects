package com.bricks.blogsystem.service_impl;

import com.bricks.blogsystem.entities.User;
import com.bricks.blogsystem.mapper.UserMapper;
import com.bricks.blogsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public int register(User user) {
        return userMapper.insertUser(user);
    }

    @Override
    public String login(String username, String password) {
        User user = userMapper.selectUserByUsername(username);
        if (user!= null && user.getPassword().equals(password)) {
            // 这里可以根据实际情况考虑生成并返回token等认证相关逻辑，暂省略复杂实现
            return "token_example";
        }
        return null;
    }

    @Override
    public Optional<User> getUserById(Long userId) {
        User user = userMapper.selectUserById(userId);
        return Optional.ofNullable(user);
    }
}