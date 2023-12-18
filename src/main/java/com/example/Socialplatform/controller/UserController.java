package com.example.Socialplatform.controller;

import com.example.Socialplatform.dtos.UserDTO;
import com.example.Socialplatform.model.User;
import com.example.Socialplatform.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody UserDTO userDTO){
        userService.registerUser(userDTO);
        return ResponseEntity.ok("User Registered successfully");
    }
    @GetMapping("/{userId}")
    public ResponseEntity<UserDTO> getUserProfile(@PathVariable Long userId) {
        // Implement logic to retrieve user profile
        UserDTO userDTO = userService.getUserProfile(userId);
        return ResponseEntity.ok(userDTO);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<String> updateUserProfile(@PathVariable Long userId, @RequestBody UserDTO userDTO) {
        // Implement logic to update user profile
        userService.updateUserProfile(userId, userDTO);
        return ResponseEntity.ok("User profile updated successfully");
    }

    // Other user-related endpoints (authentication, authorization) can be added here

}
