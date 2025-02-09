package com.bricks.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bricks.blog.entities.Articles;
import com.bricks.blog.entities.Categories;
import com.bricks.blog.entities.Comments;
import com.bricks.blog.entities.Users;
import com.bricks.blog.mapper.CategoriesMapper;
import com.bricks.blog.mapper.CommentsMapper;
import com.bricks.blog.mapper.UsersMapper;
import com.bricks.blog.service.ArticlesService;
import com.bricks.blog.mapper.ArticlesMapper;
import com.bricks.blog.vo.ArticleInfoVo;
import com.bricks.blog.vo.ArticlePublishVo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Service
@Data
@AllArgsConstructor
public class ArticlesServiceImpl extends ServiceImpl<ArticlesMapper, Articles>
        implements ArticlesService {
    private ArticlesMapper articlesMapper;
    private UsersMapper usersMapper;
    private CommentsMapper commentsMapper;
    private CategoriesMapper categoriesMapper;

    /**
     * Publish the article by articlePublishVo
     * If success return true, otherwise false
     *
     * @param articlePublish the publishing article bus
     * @return success or not
     */
    public Boolean publishArticle(ArticlePublishVo articlePublish) {
        Articles articles = new Articles();

        articles.setTitle(articlePublish.getTitle());
        articles.setContent(articlePublish.getContent());

        // Judge category value is exist or not.
        Categories category = categoriesMapper.selectOne(new QueryWrapper<Categories>()
                .eq("category_name", articlePublish.getCategory()));
        if (category == null) {
            return false;
        }

        articles.setCategoryId(category.getId());


        // Judge if not exist user_id in user table.
        Users usersTableObj = usersMapper.selectById(articlePublish.getAuthor());
        if (usersTableObj == null) {
            return false;
        }

        articles.setAuthorId(articlePublish.getAuthor());

        // Get current time to put the entity of article
        // the creation time and the update time are same time
        Date currentTime = new Date(new java.util.Date().getTime());
        articles.setCreateTime(currentTime);

        articles.setUpdateTime(currentTime);
        articles.setViews(0);

        // Insert it
        articlesMapper.insert(articles);
        return true;
    }

    /**
     * @param id article's id
     * @return it will return an ArticleInfoVo for response
     */
    public ArticleInfoVo getArticleInfoById(Long id) {
        ArticleInfoVo articleInfoVo = new ArticleInfoVo();

        // Judge the id is validation or not.
        Articles articles = articlesMapper.selectById(id);
        if (articles == null) {
            return null;
        }

        articleInfoVo.setTitle(articles.getTitle());
        articleInfoVo.setContent(articles.getContent());
        articleInfoVo.setAuthor(articles.getAuthorId());

        // Get comments from comment table
        // Now, don't care the article is belonged to the user or not.
        List<Comments> comments = commentsMapper.selectList(new QueryWrapper<Comments>().eq("article_id", id));
        articleInfoVo.setComments(comments);

        return articleInfoVo;
    }

    public List<ArticleInfoVo> getArticleInfoList() {
        List<ArticleInfoVo> articleInfoVoList = new ArrayList<>();
        List<Articles> articles = articlesMapper.selectList(null);
        for (Articles article : articles) {
            ArticleInfoVo articleInfoVo = new ArticleInfoVo();
            articleInfoVo.setTitle(article.getTitle());
            articleInfoVo.setContent(article.getContent());
            articleInfoVo.setAuthor(article.getAuthorId());
            articleInfoVoList.add(articleInfoVo);
        }

        return articleInfoVoList;
    }

}




