package com.bricks.blogsystem.mapper;

import com.bricks.blogsystem.entities.Article;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface ArticleMapper {
    int insertArticle(Article article);
    List<Article> selectArticlesByCategoryId(@Param("categoryId") Long categoryId);
    List<Article> selectAllArticles();
    Article selectArticleById(@Param("articleId") Long articleId);
    void updateArticleViews(@Param("articleId") Long articleId);
}