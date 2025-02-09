package com.bricks.blogsystem.mapper;


import com.bricks.blogsystem.entities.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {
    int insertUser(User user);
    User selectUserByUsername(@Param("username") String username);
    User selectUserById(@Param("id") Long id);
}