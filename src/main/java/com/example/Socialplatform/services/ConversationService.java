package com.example.Socialplatform.services;

import com.example.Socialplatform.Exception.NotFoundException;
import com.example.Socialplatform.dtos.ConversationDTO;
import com.example.Socialplatform.dtos.ConversationRequestDTO;
import com.example.Socialplatform.model.Conversation;
import com.example.Socialplatform.model.User;
import com.example.Socialplatform.repository.ConversationRepository;
import com.example.Socialplatform.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ConversationService {
    @Autowired
    private ConversationRepository conversationRepository;

    @Autowired
    private UserRepository userRepository;

    public List<ConversationDTO> getUserConversations(Long userId) {
        // Retrieve conversations for a specific user
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("User not found with id: " + userId));

        List<Conversation> userConversations = conversationRepository.findByUser1OrUser2(user, user);

        return userConversations.stream()
                .map(this::convertToConversationDTO)
                .collect(Collectors.toList());
    }

    public void createConversation(ConversationRequestDTO conversationRequestDTO) {
        // Create a new conversation based on the provided details
        User user1 = userRepository.findById(conversationRequestDTO.getUser1Id())
                .orElseThrow(() -> new NotFoundException("User not found with id: " + conversationRequestDTO.getUser1Id()));

        User user2 = userRepository.findById(conversationRequestDTO.getUser2Id())
                .orElseThrow(() -> new NotFoundException("User not found with id: " + conversationRequestDTO.getUser2Id()));

        // Check if a conversation already exists
        if (!conversationExists(user1, user2)) {
            Conversation conversation = new Conversation();
            conversation.setUser1(user1);
            conversation.setUser2(user2);

            conversationRepository.save(conversation);
        }
    }

    // Other conversation-related methods can be added here

    private ConversationDTO convertToConversationDTO(Conversation conversation) {
        // Convert Conversation entity to ConversationDTO
        ConversationDTO conversationDTO = new ConversationDTO();
        conversationDTO.setId(conversation.getId());
        conversationDTO.setUser1Id(conversation.getUser1().getId());
        conversationDTO.setUser2Id(conversation.getUser2().getId());
        // Add other fields as needed

        return conversationDTO;
    }

    private boolean conversationExists(User user1, User user2) {
        // Check if a conversation already exists between two users
        return conversationRepository.existsByUser1AndUser2(user1, user2)
                || conversationRepository.existsByUser1AndUser2(user2, user1);
    }



}
