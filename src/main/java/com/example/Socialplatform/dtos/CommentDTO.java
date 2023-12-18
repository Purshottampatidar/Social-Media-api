package com.example.Socialplatform.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentDTO {
    private Long id;
    private Long userId;
    private Long postId;
    private String content;
}
