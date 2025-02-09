package com.bricks.blogsystem.controller;

import com.bricks.blogsystem.entities.User;
import com.bricks.blogsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    // 用户注册接口
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody User user) {
        int result = userService.register(user);
        if (result > 0) {
            return ResponseEntity.status(HttpStatus.CREATED).body("注册成功");
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("注册失败");
    }


    // 用户登录接口
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam String username, @RequestParam String password) {
        String token = userService.login(username, password);

        if (token!= null) {
            return ResponseEntity.ok(token);
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("用户名或密码错误");
    }

//    // 用户登录接口
//    @PostMapping("/login")
//    public ResponseEntity<String> loginWithPost(@RequestBody UserVO user) {
//        String token = userService.login(user.getUsername(), user.getPassword());
//
//        if (token!= null) {
//            return ResponseEntity.ok(token);
//        }
//        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("用户名或密码错误");
//    }

    // 获取用户信息接口
    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable Long userId) {
        Optional<User> optionalUser = userService.getUserById(userId);
        return optionalUser.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}

