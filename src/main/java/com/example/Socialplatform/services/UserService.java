package com.example.Socialplatform.services;

import com.example.Socialplatform.Exception.NotFoundException;
import com.example.Socialplatform.dtos.UserDTO;
import com.example.Socialplatform.model.User;
import com.example.Socialplatform.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public void registerUser(UserDTO userDTO) {
        String hashedPassword = passwordEncoder.encode(userDTO.getPassword());

        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setPassword(hashedPassword);
        userRepository.save(user);
    }

    // Other methods...

    public UserDTO getUserProfile(Long userId) {
        // Implement logic to retrieve user profile
        // Convert User entity to UserDTO for response
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("User not found with id: " + userId));

        return convertToUserDTO(user);
    }

    public void updateUserProfile(Long userId, UserDTO userDTO) {
        // Implement logic to update user profile
        // Retrieve user from the database, update fields, and save
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("User not found with id: " + userId));

        user.setBio(userDTO.getBio());
        user.setProfilePicture(userDTO.getProfilePicture());

        userRepository.save(user);
    }

    // Other user-related business logic can be added here

    private UserDTO convertToUserDTO(User user) {
        // Convert User entity to UserDTO
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setUsername(user.getUsername());
        userDTO.setEmail(user.getEmail());
        userDTO.setBio(user.getBio());
        userDTO.setProfilePicture(user.getProfilePicture());
        // Other fields

        return userDTO;
    }
}
