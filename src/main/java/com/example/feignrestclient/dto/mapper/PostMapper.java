package com.example.feignrestclient.dto.mapper;

import com.example.feignrestclient.dto.Post;
import com.example.feignrestclient.dto.PostDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PostMapper {
    PostDto toDto(Post post);
    Post toEntity(PostDto postDto);
}

