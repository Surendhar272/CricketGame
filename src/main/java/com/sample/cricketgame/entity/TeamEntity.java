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
public class TeamEntity {
    @Id
    private String teamId;
    private String teamName;

//    @DBRef
//    private List<PlayerEntity> players;
//
//    @DBRef
//    private List<MatchEntity> matches;

    // Constructors, getters, and setters
}