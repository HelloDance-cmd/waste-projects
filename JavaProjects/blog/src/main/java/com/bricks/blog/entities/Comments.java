package com.bricks.blog.entities;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import lombok.Data;

/**
 * @TableName comments
 */
@TableName(value ="comments")
@Data
public class Comments {
    private Long id;

    private Long articleId;

    private Long userId;

    private String commentContent;

    private Date commentTime;

    private Long parentCommentId;
}