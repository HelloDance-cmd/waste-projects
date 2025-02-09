package com.bricks.blogsystem.service;
import com.bricks.blogsystem.entities.Article;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ArticleService {
    int publishArticle(Article article);
    List<Article> getArticleListByCategory(Long categoryId);
    List<Article> getArticleListAll();
    Article getArticleById(Long articleId);
}