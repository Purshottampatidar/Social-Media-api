package com.example.Socialplatform.dtos;

import com.example.Socialplatform.Enums.PrivacySetting;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostDTO {
    private Long id;
    private Long userId;
    private String content;
    private String mediaUrl;
    private PrivacySetting privacySetting;
}
