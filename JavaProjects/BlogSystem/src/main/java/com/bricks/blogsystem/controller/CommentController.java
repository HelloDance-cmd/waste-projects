package com.bricks.blogsystem.controller;

import com.bricks.blogsystem.entities.Comment;
import com.bricks.blogsystem.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    // 发表评论接口
    @PostMapping
    public ResponseEntity<String> postComment(@RequestBody Comment comment) {
        int result = commentService.postComment(comment);
        if (result > 0) {
            return ResponseEntity.status(HttpStatus.CREATED).body("评论发表成功");
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("评论发表失败");
    }

    // 获取评论列表接口
    @GetMapping("/article/{articleId}")
    public ResponseEntity<List<Comment>> getCommentListByArticleId(@PathVariable Long articleId) {
        List<Comment> commentList = commentService.getCommentListByArticleId(articleId);
        return ResponseEntity.ok(commentList);
    }
}