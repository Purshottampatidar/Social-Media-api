package com.example.Socialplatform.repository;

import com.example.Socialplatform.model.Comment;
import com.example.Socialplatform.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment,Long> {
    List<Comment> findByPostOrderByCreatedDateDesc(Post post);
}
