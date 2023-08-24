package com.example.feignrestclient.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PostDto {
    private Integer id;
    private String title;
    private String email;
    private String body;
}
