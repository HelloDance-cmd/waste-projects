package com.bricks.blog.vo;

import com.bricks.blog.entities.Comments;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArticleInfoVo {
    private String title;
    private Long author;
    private String content;
    private List<Comments> comments;
}
