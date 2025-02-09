package com.bricks.blogsystem.service_impl;

import com.bricks.blogsystem.entities.Article;
import com.bricks.blogsystem.mapper.ArticleMapper;
import com.bricks.blogsystem.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public int publishArticle(Article article) {
        return articleMapper.insertArticle(article);
    }

    @Override
    public List<Article> getArticleListByCategory(Long categoryId) {
        return articleMapper.selectArticlesByCategoryId(categoryId);
    }

    @Override
    public List<Article> getArticleListAll() {
        return articleMapper.selectAllArticles();
    }

    @Override
    public Article getArticleById(Long articleId) {
        Article article = articleMapper.selectArticleById(articleId);
        if (article!= null) {
            articleMapper.updateArticleViews(articleId);
        }
        return article;
    }
}