package com.bricks.blogsystem.controller;

import com.bricks.blogsystem.entities.Article;
import com.bricks.blogsystem.service.ArticleService;
import com.bricks.blogsystem.utils.UserUntil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/articles")
public class ArticleController {

    @Autowired
    private ArticleService articleService;
    @Autowired
    private UserUntil userUntil;

    // 发布文章接口
    @PostMapping
    public ResponseEntity<String> publishArticle(@RequestBody Article article) {
        if(!userUntil.userExist(article.getId())) {
            return ResponseEntity.status(HttpStatus.IM_USED).body("文章发布失败");
        }

        int result = articleService.publishArticle(article);
        if (result > 0) {
            return ResponseEntity.status(HttpStatus.CREATED).body("文章发布成功");
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("文章发布失败");
    }

    // 获取文章列表接口（按分类）
    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<Article>> getArticleListByCategory(@PathVariable Long categoryId) {
        List<Article> articleList = articleService.getArticleListByCategory(categoryId);
        return ResponseEntity.ok(articleList);
    }

    // 获取文章列表接口（全部文章）
    @GetMapping
    public ResponseEntity<List<Article>> getArticleListAll() {
        List<Article> articleList = articleService.getArticleListAll();
        return ResponseEntity.ok(articleList);
    }

    // 获取文章详情接口
    @GetMapping("/{articleId}")
    public ResponseEntity<Article> getArticleById(@PathVariable Long articleId) {
        Article article = articleService.getArticleById(articleId);
        return article!= null? ResponseEntity.ok(article) : ResponseEntity.notFound().build();
    }
}