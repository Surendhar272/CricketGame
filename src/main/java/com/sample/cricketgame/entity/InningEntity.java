package com.sample.cricketgame.entity;


import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Document
public class InningEntity {
    @Id
    private String inningId;
    private int runsScored;
    private int wicketsLost;

    @DBRef
    private TeamEntity battingTeam;

    @DBRef
    private TeamEntity bowlingTeam;

    @DBRef
    private MatchEntity match;

    // Constructors, getters, and setters
}