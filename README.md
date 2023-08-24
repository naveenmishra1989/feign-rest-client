#http://localhost:9111/swagger-ui/index.html#/

##Recommended approach
 @GetMapping("/posts")
  ResponseEntity<List<Post>> getPosts();

  @GetMapping("/posts/{id}")
  ResponseEntity<Optional<Post>> getPost(@PathVariable Integer id);
