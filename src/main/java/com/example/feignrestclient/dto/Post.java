package com.example.feignrestclient.dto;

import lombok.Data;

@Data
public class Post {
    private Integer userId;
    private Integer id;
    private String title;
    private String email;
    private String body;

}
