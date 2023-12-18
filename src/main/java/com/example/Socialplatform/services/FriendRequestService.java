package com.example.Socialplatform.services;

import com.example.Socialplatform.Enums.FriendRequestStatus;
import com.example.Socialplatform.Exception.BadRequestException;
import com.example.Socialplatform.Exception.NotFoundException;
import com.example.Socialplatform.dtos.FriendRequestDTO;
import com.example.Socialplatform.model.FriendRequest;
import com.example.Socialplatform.model.User;
import com.example.Socialplatform.repository.FriendRequestRepository;
import com.example.Socialplatform.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FriendRequestService {


        @Autowired
        private FriendRequestRepository friendRequestRepository;

        @Autowired
        private UserRepository userRepository;

        public void sendFriendRequest(FriendRequestDTO friendRequestDTO) {
            // Implement logic to send a friend request
            // Validate sender and receiver, existing friend requests, etc.
            // Save the friend request to the database
            User sender = userRepository.findById(friendRequestDTO.getSenderId())
                    .orElseThrow(() -> new NotFoundException("User not found with id: " + friendRequestDTO.getSenderId()));

            User receiver = userRepository.findById(friendRequestDTO.getReceiverId())
                    .orElseThrow(() -> new NotFoundException("User not found with id: " + friendRequestDTO.getReceiverId()));

            // Check if a friend request already exists
            if (friendRequestRepository.existsBySenderAndReceiverAndStatus(sender, receiver, FriendRequestStatus.PENDING)) {
                throw new BadRequestException("Friend request already sent");
            }

            FriendRequest friendRequest = new FriendRequest();
            friendRequest.setSender(sender);
            friendRequest.setReceiver(receiver);
            friendRequest.setStatus(FriendRequestStatus.PENDING);

            friendRequestRepository.save(friendRequest);
        }

        public void acceptFriendRequest(Long requestId) {
            // Implement logic to accept a friend request
            // Retrieve friend request from the database, update status, and save
            FriendRequest friendRequest = friendRequestRepository.findById(requestId)
                    .orElseThrow(() -> new NotFoundException("Friend request not found with id: " + requestId));

            friendRequest.setStatus(FriendRequestStatus.ACCEPTED);
            friendRequestRepository.save(friendRequest);
        }

        // Other friend request-related business logic can be added here

}
