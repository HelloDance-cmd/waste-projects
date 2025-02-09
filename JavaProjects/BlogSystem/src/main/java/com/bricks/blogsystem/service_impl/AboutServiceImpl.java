package com.bricks.blogsystem.service_impl;

import com.bricks.blogsystem.entities.AboutMe;
import com.bricks.blogsystem.mapper.AboutMeMapper;
import com.bricks.blogsystem.service.AboutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AboutServiceImpl implements AboutService {
    @Autowired
    AboutMeMapper aboutMeMapper;
    @Override
    public AboutMe getMe() {
        return aboutMeMapper.getMe();
    }
}
