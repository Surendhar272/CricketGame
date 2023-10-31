package com.sample.cricketgame.model;

import com.sample.cricketgame.entity.TeamEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MatchModel {

    @Id
    private String matchId;
    private String result;
    private String teamA;
    private String teamB;

    public void addAttribute(String text, String result) {
        this.result = result;
    }

    public String getMatchId() {
        return matchId;
    }

    public String getResult() {
        return result;
    }

    public String getTeamA() {
        return teamA;
    }

    public String getTeamB() {
        return teamB;
    }

    public void setMatchId(String matchId) {
        this.matchId = matchId;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public void setTeamA(String teamA) {
        this.teamA = teamA;
    }

    public void setTeamB(String teamB) {
        this.teamB = teamB;
    }
}
