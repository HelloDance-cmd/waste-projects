package com.bricks.blogsystem.service_impl;

import com.bricks.blogsystem.entities.Comment;
import com.bricks.blogsystem.mapper.CommentMapper;
import com.bricks.blogsystem.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentMapper commentMapper;

    @Override
    public int postComment(Comment comment) {
        return commentMapper.insertComment(comment);
    }

    @Override
    public List<Comment> getCommentListByArticleId(Long articleId) {
        return commentMapper.selectCommentsByArticleId(articleId);
    }
}