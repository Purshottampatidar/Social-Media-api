package com.example.Socialplatform.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {
    private Long id;
    private String username;
    private String email;
    private String bio;
    private String password;
    private String profilePicture;
}
