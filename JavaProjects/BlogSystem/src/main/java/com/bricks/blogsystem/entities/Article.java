package com.bricks.blogsystem.entities;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.sql.Date;

@Data
@Component
public class Article {
    private Long id;
    private String title;
    private String content;
    private Long authorId;
    private Date createTime;
    private Date updateTime;
    private Long categoryId;
    private Integer views;
}