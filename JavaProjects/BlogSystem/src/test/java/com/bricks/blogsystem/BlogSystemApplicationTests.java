package com.bricks.blogsystem;

import com.bricks.blogsystem.entities.Article;
import com.bricks.blogsystem.entities.User;
import com.bricks.blogsystem.service.ArticleService;
import com.bricks.blogsystem.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class BlogSystemApplicationTests {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private UserService userService;
    @Test
    void contextLoads() {
        Long id = 1L;
        List<Article> articleList = articleService.getArticleListByCategory(id);
        System.out.println(articleList);


    }

}
