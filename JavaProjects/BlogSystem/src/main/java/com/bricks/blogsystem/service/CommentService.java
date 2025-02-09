package com.bricks.blogsystem.service;


import com.bricks.blogsystem.entities.Comment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CommentService {
    int postComment(Comment comment);
    List<Comment> getCommentListByArticleId(Long articleId);
}
