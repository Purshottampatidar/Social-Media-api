package com.example.Socialplatform.controller;

import com.example.Socialplatform.dtos.MessageDTO;
import com.example.Socialplatform.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/messages")
public class MessageController {
    @Autowired
    private MessageService messageService;

    @PostMapping
    public ResponseEntity<String> sendMessage(@RequestBody MessageDTO messageDTO) {
        // Implement logic to send a message
        messageService.sendMessage(messageDTO);
        return ResponseEntity.ok("Message sent successfully");
    }

    @GetMapping("/{messageId}")
    public ResponseEntity<MessageDTO> getMessageDetails(@PathVariable Long messageId) {
        // Implement logic to retrieve message details
        MessageDTO messageDTO = messageService.getMessageDetails(messageId);
        return ResponseEntity.ok(messageDTO);
    }
}
