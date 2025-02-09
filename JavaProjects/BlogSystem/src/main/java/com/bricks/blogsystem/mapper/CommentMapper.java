package com.bricks.blogsystem.mapper;

import com.bricks.blogsystem.entities.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface CommentMapper {
    int insertComment(Comment comment);
    List<Comment> selectCommentsByArticleId(@Param("articleId") Long articleId);
}