package com.example.Socialplatform.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table
@Getter
@Setter
public class ConversationRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long user1Id;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long user2Id;
}
