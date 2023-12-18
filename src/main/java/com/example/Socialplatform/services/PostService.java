package com.example.Socialplatform.services;

import com.example.Socialplatform.Exception.NotFoundException;
import com.example.Socialplatform.dtos.CommentDTO;
import com.example.Socialplatform.dtos.PostDTO;
import com.example.Socialplatform.model.Comment;
import com.example.Socialplatform.model.Post;
import com.example.Socialplatform.model.User;
import com.example.Socialplatform.repository.PostRepository;
import com.example.Socialplatform.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {



        @Autowired
        private PostRepository postRepository;

        @Autowired
        private UserRepository userRepository;

        public void createPost(PostDTO postDTO) {
            // Implement logic to create a post
            // Validate user, privacy settings, etc.
            // Save the post to the database
            User user = userRepository.findById(postDTO.getUserId())
                    .orElseThrow(() -> new NotFoundException("User not found with id: " + postDTO.getUserId()));

            Post post = new Post();
            post.setUser(user);
            post.setContent(postDTO.getContent());
            post.setMediaUrl(postDTO.getMediaUrl());
            post.setPrivacySetting(postDTO.getPrivacySetting());

            postRepository.save(post);
        }

        public PostDTO getPostDetails(Long postId) {
            // Implement logic to retrieve post details
            // Convert Post entity to PostDTO for response
            Post post = postRepository.findById(postId)
                    .orElseThrow(() -> new NotFoundException("Post not found with id: " + postId));

            return convertToPostDTO(post);
        }

        public void addCommentToPost(Long postId, CommentDTO commentDTO) {
            // Implement logic to add a comment to a post
            // Retrieve post from the database, add comment, and save
            Post post = postRepository.findById(postId)
                    .orElseThrow(() -> new NotFoundException("Post not found with id: " + postId));

            // Validate user, post ownership, etc.

            Comment comment = new Comment();
            comment.setUser(userRepository.findById(commentDTO.getUserId())
                    .orElseThrow(() -> new NotFoundException("User not found with id: " + commentDTO.getUserId())));
            comment.setPost(post);
            comment.setContent(commentDTO.getContent());

            post.getComments().add(comment);
            postRepository.save(post);
        }

        // Other post-related business logic can be added here

        private PostDTO convertToPostDTO(Post post) {
            // Convert Post entity to PostDTO
            PostDTO postDTO = new PostDTO();
            postDTO.setId(post.getId());
            postDTO.setUserId(post.getUser().getId());
            postDTO.setContent(post.getContent());
            postDTO.setMediaUrl(post.getMediaUrl());
            postDTO.setPrivacySetting(post.getPrivacySetting());
            // Other fields

            return postDTO;
        }
}
