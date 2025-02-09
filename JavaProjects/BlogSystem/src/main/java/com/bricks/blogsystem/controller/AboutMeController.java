package com.bricks.blogsystem.controller;


import com.bricks.blogsystem.entities.AboutMe;
import com.bricks.blogsystem.service.AboutService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("aboutme")
public class AboutMeController {
    private final AboutService aboutService;

    public AboutMeController(AboutService aboutService) {
        this.aboutService = aboutService;
    }

    @GetMapping
    public ResponseEntity<AboutMe> getMe() {
        return ResponseEntity.ok(aboutService.getMe());
    }
}
