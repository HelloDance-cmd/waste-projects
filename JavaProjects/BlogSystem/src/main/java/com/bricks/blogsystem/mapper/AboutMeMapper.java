package com.bricks.blogsystem.mapper;

import com.bricks.blogsystem.entities.AboutMe;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AboutMeMapper {
    AboutMe getMe();
}
