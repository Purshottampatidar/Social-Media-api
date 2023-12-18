package com.example.Socialplatform.repository;

import com.example.Socialplatform.model.Post;
import com.example.Socialplatform.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post,Long> {
    List<Post> findByUserOrderByCreatedDataDesc(User user);
}
