package com.bricks.blog.controller;

import com.bricks.blog.entities.Users;
import com.bricks.blog.service.impl.UsersServiceImpl;
import com.bricks.blog.vo.UserLoginVo;
import com.bricks.blog.vo.UserRegisterVO;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user/")
@AllArgsConstructor
public class UserController {
    private UsersServiceImpl usersService;

    @PostMapping("/login/")
    public String login(@RequestBody UserLoginVo user) {
        String password = user.getPassword();
        if (user.getUsername() == null) {
            if (user.getEmail() == null) {
                return null;
            }
            return usersService.loginByEmail(user.getEmail(), password) ? "success" : "fail";
        }
        return usersService.loginByUserName(user.getUsername(), password) ? "success" : "fail";
    }

    @PostMapping("/info/")
    public Users info(@RequestParam Integer userId) {
        return usersService.getById(userId);
    }

    @GetMapping("/register/")
    public String register(@RequestBody UserRegisterVO userVo) {
        Users user = new Users();

        user.setUsername(userVo.getUsername());
        user.setPassword(userVo.getPassword());
        user.setEmail(userVo.getEmail());
        user.setBirth(userVo.getBirthday());

        boolean successOrNot = usersService.save(user);
        return successOrNot ? "success" : "fail";
    }
}
