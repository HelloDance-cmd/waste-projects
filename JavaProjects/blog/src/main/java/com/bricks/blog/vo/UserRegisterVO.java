package com.bricks.blog.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class UserRegisterVO {
    private String username;
    private String password;
    private String email;
    private Date birthday;

}
