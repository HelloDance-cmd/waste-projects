package com.bricks.blog.entities;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @TableName categories
 */
@TableName(value ="categories")
@Data
public class Categories {
    private Long id;

    private String categoryName;

    private Long parentCategoryId;
}