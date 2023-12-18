package com.example.Socialplatform.services;

import com.example.Socialplatform.Exception.NotFoundException;
import com.example.Socialplatform.dtos.MessageDTO;
import com.example.Socialplatform.model.Conversation;
import com.example.Socialplatform.model.Message;
import com.example.Socialplatform.model.User;
import com.example.Socialplatform.repository.ConversationRepository;
import com.example.Socialplatform.repository.MessageRepository;
import com.example.Socialplatform.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {


        @Autowired
        private MessageRepository messageRepository;

        @Autowired
        private UserRepository userRepository;

        @Autowired
        private ConversationRepository conversationRepository;

        public void sendMessage(MessageDTO messageDTO) {
            // Implement logic to send a message
            // Validate sender and receiver, existing conversations, etc.
            // Save the message to the database
            User sender = userRepository.findById(messageDTO.getSenderId())
                    .orElseThrow(() -> new NotFoundException("User not found with id: " + messageDTO.getSenderId()));

            User receiver = userRepository.findById(messageDTO.getReceiverId())
                    .orElseThrow(() -> new NotFoundException("User not found with id: " + messageDTO.getReceiverId()));

            // Example: Check if a conversation already exists
            // You may need a more sophisticated logic depending on your requirements
            if (!conversationExists(sender, receiver)) {
                // Handle creating a new conversation
            }

            Message message = new Message();
            message.setSender(sender);
            message.setReceiver(receiver);
            message.setContent(messageDTO.getContent());

            messageRepository.save(message);
        }
        public boolean conversationExists(User user1, User user2) {
              // Implement logic to check if a conversation exists between two users
              // Here, we check if there are any messages exchanged between the two users

               List<Message> messagesFromUser1ToUser2 = messageRepository.findBySenderAndReceiverOrderByTimestamp(user1, user2);
               List<Message> messagesFromUser2ToUser1 = messageRepository.findBySenderAndReceiverOrderByTimestamp(user2, user1);

             // If there are messages in either direction, the conversation exists
               return !messagesFromUser1ToUser2.isEmpty() || !messagesFromUser2ToUser1.isEmpty();
        }
        private void createNewConversation(User user1, User user2) {
            // Implement logic to create a new conversation between two users
            // This might involve creating a new Conversation entity or any other necessary steps
            // Ensure that the necessary relationships are established for your data model

            // For example, you might want to create a new Conversation entity and save it to the database
            Conversation conversation = new Conversation();
            conversation.setUser1(user1);
            conversation.setUser2(user2);

             // Save the conversation to the database
            conversationRepository.save(conversation);
    }

        public MessageDTO getMessageDetails(Long messageId) {
            // Implement logic to retrieve message details
            // Convert Message entity to MessageDTO for response
            Message message = messageRepository.findById(messageId)
                    .orElseThrow(() -> new NotFoundException("Message not found with id: " + messageId));

            return convertToMessageDTO(message);
        }
        private MessageDTO convertToMessageDTO(Message message) {
             // Convert Message entity to MessageDTO
             MessageDTO messageDTO = new MessageDTO();
             messageDTO.setId(message.getId());
             messageDTO.setSenderId(message.getSender().getId());
             messageDTO.setReceiverId(message.getReceiver().getId());
             messageDTO.setContent(message.getContent());

             return messageDTO;
       }
}
