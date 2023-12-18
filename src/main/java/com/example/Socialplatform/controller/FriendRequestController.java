package com.example.Socialplatform.controller;

import com.example.Socialplatform.dtos.FriendRequestDTO;
import com.example.Socialplatform.services.FriendRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/friend-requests")
public class FriendRequestController {
    @Autowired
    private FriendRequestService friendRequestService;

    @PostMapping
    public ResponseEntity<String> sendFriendRequest(@RequestBody FriendRequestDTO friendRequestDTO) {
        // Implement logic to send a friend request
        friendRequestService.sendFriendRequest(friendRequestDTO);
        return ResponseEntity.ok("Friend request sent successfully");
    }

    @PutMapping("/{requestId}/accept")
    public ResponseEntity<String> acceptFriendRequest(@PathVariable Long requestId) {
        // Implement logic to accept a friend request
        friendRequestService.acceptFriendRequest(requestId);
        return ResponseEntity.ok("Friend request accepted successfully");
    }

    // Other friend request-related endpoints can be added here
}
