package com.bricks.blog.controller;

import com.bricks.blog.service.impl.ArticlesServiceImpl;
import com.bricks.blog.vo.ArticleInfoVo;
import com.bricks.blog.vo.ArticlePublishVo;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/article")
@AllArgsConstructor
public class ArticleController {
    private ArticlesServiceImpl articlesService;

    @PostMapping("/publish/")
    public String publishArticle(@NonNull @RequestBody ArticlePublishVo articlePublish) {
        Boolean successOrNot = articlesService.publishArticle(articlePublish);
        return successOrNot ? "success" : "fail";
    }


    @GetMapping("/info/{id}")
    public ArticleInfoVo getArticleInfo(@PathVariable Integer id) {
        // Don't care this would be null.
        return articlesService.getArticleInfoById(Long.valueOf(id));
    }

    @GetMapping("/info/")
    public List<ArticleInfoVo> getArticleInfoList() {
        return articlesService.getArticleInfoList();
    }
}
