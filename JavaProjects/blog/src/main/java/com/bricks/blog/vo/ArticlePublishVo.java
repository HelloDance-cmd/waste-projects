package com.bricks.blog.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.sql.Date;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ArticlePublishVo {
    private String title;
    private String content;
    private Long author;
    private Date publishDate;
    private String category;
}
