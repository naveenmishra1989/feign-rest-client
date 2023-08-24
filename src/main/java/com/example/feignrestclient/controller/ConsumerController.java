package com.example.feignrestclient.controller;

import com.example.feignrestclient.dto.PostDto;
import com.example.feignrestclient.dto.mapper.PostMapper;
import com.example.feignrestclient.service.ConsumerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class ConsumerController {

    private final ConsumerService consumerService;
    private final PostMapper postMapper;

    //http://localhost:9111/getAllPost
    @GetMapping("/getAllPost")
    public ResponseEntity<List<PostDto>> getPosts() {
        List<PostDto> postDtos = consumerService.getPosts().stream().map(postMapper::toDto)
                .collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(postDtos);
    }

    //http://localhost:9111/getAllPost/15
    @GetMapping("/getAllPost/{id}")
    public ResponseEntity<PostDto> getPost(@PathVariable Integer id) {
        PostDto postDto = consumerService.getPost(id).map(postMapper::toDto).orElse(null);
        return ResponseEntity.status(HttpStatus.OK).body(postDto);
    }

    //http://localhost:9111/getAllComments
    @GetMapping("/getAllComments")
    public ResponseEntity<String> getComments() {
        final String comments = consumerService.getComments()
                .orElse(null);
        return ResponseEntity.status(HttpStatus.OK).body(comments);
    }

    //http://localhost:9111/get/3/comments
    @GetMapping("get/{postId}/comments")
    public ResponseEntity<List<PostDto>> getCommentsPostId(@PathVariable Integer postId) {
        consumerService.getCommentsPostId(postId).stream()
                .filter(post -> post.getId().equals(postId)).findFirst()
                .orElseThrow(() -> new RuntimeException("Post not found"));
        List<PostDto> postDtos = consumerService.getCommentsPostId(postId).stream().map(postMapper::toDto)
                .collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(postDtos);
    }

}
