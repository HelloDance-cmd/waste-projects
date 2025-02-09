package com.bricks.blog.entities;

import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import lombok.Data;

/**
 * @TableName articles
 */
@TableName(value ="articles")
@Data
public class Articles {
    private Long id;

    private String title;

    private String content;

    private Long authorId;

    private Date createTime;

    private Date updateTime;

    private Long categoryId;

    private Integer views;
}