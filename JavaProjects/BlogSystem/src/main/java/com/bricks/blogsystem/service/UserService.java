package com.bricks.blogsystem.service;

import com.bricks.blogsystem.entities.User;

import java.util.Optional;

public interface UserService {
    int register(User user);
    String login(String username, String password);
    Optional<User> getUserById(Long userId);
}