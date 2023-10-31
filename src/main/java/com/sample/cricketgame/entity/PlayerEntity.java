package com.sample.cricketgame.entity;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Document
public class PlayerEntity {
    @Id
    private String playerId;
    private String playerName;
    private String role;
    private String battingStyle;
    private String bowlingStyle;

    @DBRef
    private TeamEntity team;

    // Constructors, getters, and setters
}