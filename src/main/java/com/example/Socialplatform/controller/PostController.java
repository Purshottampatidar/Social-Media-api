package com.example.Socialplatform.controller;

import com.example.Socialplatform.dtos.CommentDTO;
import com.example.Socialplatform.dtos.PostDTO;
import com.example.Socialplatform.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping
    public ResponseEntity<String> createPost(@RequestBody PostDTO postDTO) {
        // Implement logic to create a post
        postService.createPost(postDTO);
        return ResponseEntity.ok("Post created successfully");
    }

    @GetMapping("/{postId}")
    public ResponseEntity<PostDTO> getPostDetails(@PathVariable Long postId) {
        // Implement logic to retrieve post details
        PostDTO postDTO = postService.getPostDetails(postId);
        return ResponseEntity.ok(postDTO);
    }

    @PostMapping("/{postId}/comment")
    public ResponseEntity<String> addCommentToPost(@PathVariable Long postId, @RequestBody CommentDTO commentDTO) {
        // Implement logic to add a comment to a post
        postService.addCommentToPost(postId, commentDTO);
        return ResponseEntity.ok("Comment added successfully");
    }

    // Other post-related endpoints can be added here

}
