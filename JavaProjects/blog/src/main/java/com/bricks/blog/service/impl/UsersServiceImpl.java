package com.bricks.blog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bricks.blog.entities.Users;
import com.bricks.blog.service.UsersService;
import com.bricks.blog.mapper.UsersMapper;
import org.springframework.stereotype.Service;

/**
* @author wu-ji
* @description 针对表【users】的数据库操作Service实现
* @createDate 2025-01-16 14:47:01
*/
@Service
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users>
    implements UsersService{

    public Boolean loginByEmail(String email, String password) {
        return true;
    }

    public Boolean loginByUserName(String userName, String password) {
        return true;
    }
}




