package com.sample.cricketgame.entity;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Document
public class MatchEntity {
    @Id
    private String matchId;
    private String result;
    @DBRef
    private TeamEntity teamA;
    @DBRef
    private TeamEntity teamB;

    @DBRef
    private List<InningEntity> innings;

    // Constructors, getters, and setters
}