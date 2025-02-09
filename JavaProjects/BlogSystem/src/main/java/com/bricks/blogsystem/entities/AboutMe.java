package com.bricks.blogsystem.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;

@Data
@EnableJpaRepositories
public class AboutMe {
    private Long id;
    private String full_name;
    private String nick_name;
    private String profile_picture_url;

    private String short_bio;

    private String detailed_bio;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birth_date;

    private String hometown;

    private String current_location;

    private String occupation;

    private String hobbies;

    private String contact_email;

    private String personal_website_url;

    private String social_media_links;

    private String skills;

    private String education;

    private String awards_and_achievements;

    @CreatedDate
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date created_at;

    @LastModifiedDate
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updated_at;
}