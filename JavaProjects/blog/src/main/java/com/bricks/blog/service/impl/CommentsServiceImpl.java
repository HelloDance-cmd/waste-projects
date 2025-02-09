package com.bricks.blog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bricks.blog.entities.Comments;
import com.bricks.blog.service.CommentsService;
import com.bricks.blog.mapper.CommentsMapper;
import org.springframework.stereotype.Service;

/**
* @author wu-ji
* @description 针对表【comments】的数据库操作Service实现
* @createDate 2025-01-16 14:47:01
*/
@Service
public class CommentsServiceImpl extends ServiceImpl<CommentsMapper, Comments>
    implements CommentsService{

}




