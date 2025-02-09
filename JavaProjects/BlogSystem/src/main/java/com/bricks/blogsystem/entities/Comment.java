package com.bricks.blogsystem.entities;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.sql.Date;

@Data
@Component
public class Comment {
    private Long id;
    private Long articleId;
    private Long userId;
    private String commentContent;
    private Date commentTime;
    private Long parentCommentId;
}