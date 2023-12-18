package com.example.Socialplatform.repository;

import com.example.Socialplatform.model.Conversation;
import com.example.Socialplatform.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ConversationRepository extends JpaRepository<Conversation ,Long> {
    List<Conversation> findByUser1OrUser2(User user1, User user2);
    boolean existsByUser1AndUser2(User user1, User user2);
}
