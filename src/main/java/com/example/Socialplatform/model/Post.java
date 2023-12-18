package com.example.Socialplatform.model;

import com.example.Socialplatform.Enums.PrivacySetting;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;
    private String mediaUrl;
    private PrivacySetting privacySetting;

    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "post")
    private List<Comment> comments;

}
