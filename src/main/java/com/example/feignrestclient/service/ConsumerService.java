package com.example.feignrestclient.service;

import com.example.feignrestclient.dto.Post;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@FeignClient(url = "https://jsonplaceholder.typicode.com/", name = "proxyClient")
public interface ConsumerService {

  @GetMapping("/posts")
  List<Post> getPosts();

  @GetMapping("/posts/{id}")
  Optional<Post> getPost(@PathVariable Integer id);

  @GetMapping("/comments")
  Optional<String> getComments();

  @GetMapping("posts/{postId}/comments")
  List<Post> getCommentsPostId(@PathVariable Integer postId);
}
