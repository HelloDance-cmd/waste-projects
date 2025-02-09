package com.bricks.blogsystem.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class UserVO {
    private String username;
    private String password;
}