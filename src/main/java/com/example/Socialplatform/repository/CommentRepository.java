package com.example.Socialplatform.repository;

import com.example.Socialplatform.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment,Long> {

}
