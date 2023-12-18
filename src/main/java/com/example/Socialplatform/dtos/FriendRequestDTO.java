package com.example.Socialplatform.dtos;

import com.example.Socialplatform.Enums.FriendRequestStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FriendRequestDTO {
    private Long id;
    private Long senderId;
    private Long receiverId;
    private FriendRequestStatus status;
}
