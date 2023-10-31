package com.sample.cricketgame.model;

import com.sample.cricketgame.entity.TeamEntity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class TeamModel {
    @Id
    private int teamId;
    private String teamName;
    public TeamModel(String teamName) {
        this.teamName = teamName;
    }
}
