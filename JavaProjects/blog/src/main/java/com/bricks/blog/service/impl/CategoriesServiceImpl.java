package com.bricks.blog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bricks.blog.entities.Categories;
import com.bricks.blog.service.CategoriesService;
import com.bricks.blog.mapper.CategoriesMapper;
import org.springframework.stereotype.Service;

/**
* @author wu-ji
* @description 针对表【categories】的数据库操作Service实现
* @createDate 2025-01-16 14:47:01
*/
@Service
public class CategoriesServiceImpl extends ServiceImpl<CategoriesMapper, Categories>
    implements CategoriesService{

}




