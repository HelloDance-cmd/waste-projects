package com.bricks.blog.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bricks.blog.entities.Articles;
import com.bricks.blog.entities.Comments;
import com.bricks.blog.entities.Users;
import com.bricks.blog.service.impl.ArticlesServiceImpl;
import com.bricks.blog.service.impl.CommentsServiceImpl;
import com.bricks.blog.service.impl.UsersServiceImpl;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("/comment/")
@AllArgsConstructor
public class CommentController {
    private CommentsServiceImpl commentsService;
    private UsersServiceImpl usersService;
    private ArticlesServiceImpl articlesService;

    @GetMapping("/article/{id}")
    public List<Comments> article(@PathVariable Integer id) {
        return commentsService.list(new QueryWrapper<Comments>().eq("article_id", id));
    }

    @GetMapping("/post")
    public String post(@NonNull @RequestParam Integer userId, @NonNull @RequestParam Integer articleId,
                       @NonNull @RequestParam String commentContent,
                       @RequestParam Integer parentId) {
        Users user = usersService.getById(userId);
        if (user == null) {
            return "The user does not exist, you are doing invalidate actions";
        }

        Comments comment = new Comments();
        ;
        // Get current time for sql.
        Date currentTime = new Date(new java.util.Date().getTime());
        comment.setCommentTime(currentTime);
        comment.setCommentContent(commentContent);
        comment.setUserId(Long.valueOf(userId));

        Articles article = articlesService.getById(articleId);
        if (article == null) {
            return "The article does not exist, you are doing invalidate actions";
        }

        comment.setArticleId(Long.valueOf(articleId));

        commentsService.save(comment);

        return "Success for push comment";
    }
}
