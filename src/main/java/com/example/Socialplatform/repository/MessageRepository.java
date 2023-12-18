package com.example.Socialplatform.repository;

import com.example.Socialplatform.model.Message;
import com.example.Socialplatform.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message,Long> {
    List<Message> findBySenderAndReceiverOrderByTimestamp(User sender, User receiver);
}
