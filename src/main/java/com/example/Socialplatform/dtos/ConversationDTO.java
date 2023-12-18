package com.example.Socialplatform.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ConversationDTO {
    private Long id;
    private Long user1Id;
    private Long user2Id;
}
