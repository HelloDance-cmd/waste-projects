package com.bricks.blogsystem.entities;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.sql.Date;

@Data
@Component
public class User {
    private Long id;
    private String username;
    private String password;
    private String email;
    private Date createTime;
    private Date updateTime;

}