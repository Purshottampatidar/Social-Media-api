package com.example.Socialplatform.controller;

import com.example.Socialplatform.dtos.ConversationDTO;
import com.example.Socialplatform.dtos.ConversationRequestDTO;
import com.example.Socialplatform.services.ConversationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/conversations")
public class ConversationController{
    @Autowired
    private ConversationService conversationService;

    @GetMapping("/{userId}")
    public ResponseEntity<List<ConversationDTO>> getUserConversations(@PathVariable Long userId) {
        // Retrieve conversations for a specific user
        List<ConversationDTO> conversations = conversationService.getUserConversations(userId);
        return ResponseEntity.ok(conversations);
    }

    @PostMapping
    public ResponseEntity<String> createConversation(@RequestBody ConversationRequestDTO conversationRequestDTO) {
        // Create a new conversation based on the provided details
        conversationService.createConversation(conversationRequestDTO);
        return ResponseEntity.ok("Conversation created successfully");
    }


}
