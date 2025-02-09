package com.bricks.blog.entities;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import lombok.Data;

/**
 * @TableName users
 */
@TableName(value ="users")
@Data
public class Users {
    private Long id;

    private String username;

    private String password;

    private String email;

    private Date createTime;

    private Date updateTime;

    private String firstName;

    private String lastName;

    private Date birth;

    private String selfEvaluation;
}