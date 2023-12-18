package com.example.Socialplatform.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MessageDTO {
    private Long id;
    private Long senderId;
    private Long receiverId;
    private String content;
}
