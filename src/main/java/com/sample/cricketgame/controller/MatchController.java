package com.sample.cricketgame.controller;

import com.sample.cricketgame.entity.MatchEntity;
import com.sample.cricketgame.entity.TeamEntity;
import com.sample.cricketgame.model.MatchModel;
import com.sample.cricketgame.model.TeamModel;
import com.sample.cricketgame.service.CricketGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class MatchController {
    private final CricketGameService cricketGameService;

    @Autowired
    public MatchController(CricketGameService cricketGameService) {
        this.cricketGameService = cricketGameService;
    }

    @PostMapping("/playMatch")
    public String playMatch(@RequestBody TeamEntity teamA, TeamEntity teamB) {
        // Simulate the match
        StringBuilder result = new StringBuilder();
        result.append("Match between ").append(teamA.getTeamName()).append(" and ").append(teamB.getTeamName()).append(":\n");

        int inningsCount = 2; // Assuming 2 innings per match

        for (int inning = 1; inning <= inningsCount; inning++) {
            result.append("Inning ").append(inning).append(":\n");

            // Simulate each ball
            int totalRuns = 0;
            int wickets = 0;
            String ballResult;

            do {
                ballResult = cricketGameService.playBall();
                result.append("Ball: ").append(ballResult).append(" | ");
                if (!"W".equals(ballResult)) {
                    totalRuns += Integer.parseInt(ballResult);
                } else {
                    wickets++;
                }
            } while (!"W".equals(ballResult) && totalRuns < 200 && wickets < 10); // Assuming 10 wickets or 200 runs is the limit

            result.append("\nInning ").append(inning).append(" ended with ").append(totalRuns).append(" runs and ").append(wickets).append(" wickets.\n");
        }

        return result.toString();
    }

    @GetMapping("/match")
    public String match(@RequestBody MatchModel model) {
        TeamModel teamA = new TeamModel(model.getTeamA());
        TeamModel teamB = new TeamModel(model.getTeamB());

        // Simulate the match
        StringBuilder result = new StringBuilder();
        result.append("Match between ").append(teamA.getTeamName()).append(" and ").append(teamB.getTeamName()).append(":\n");

        int inningsCount = 2; // Assuming 2 innings per match
        int totalRunsTeamA = 0;
        int totalRunsTeamB = 0;

        for (int inning = 1; inning <= inningsCount; inning++) {
            result.append("Inning ").append(inning).append(":\n");

            // Simulate each ball
            int totalRuns = 0;
            int wickets = 0;
            String ballResult;

            do {
                ballResult = cricketGameService.playBall();
                result.append("Ball: ").append(ballResult).append(" | ");
                if (!"W".equals(ballResult)) {
                    totalRuns += Integer.parseInt(ballResult);
                } else {
                    wickets++;
                }
            } while (!"W".equals(ballResult) && totalRuns < 200 && wickets < 10); // Assuming 10 wickets or 200 runs is the limit

            result.append("\nInning ").append(inning).append(" ended with ").append(totalRuns).append(" runs and ").append(wickets).append(" wickets.\n");

            if (inning == 1) {
                totalRunsTeamA += totalRuns;
            } else {
                totalRunsTeamB += totalRuns;
            }
        }

        // Determine the winning team
        String winningTeam;
        if (totalRunsTeamA > totalRunsTeamB) {
            winningTeam = model.getTeamA();
        } else if (totalRunsTeamB > totalRunsTeamA) {
            winningTeam = model.getTeamB();
        } else {
            winningTeam = "It's a tie!";
        }

        result.append("Match result: ").append(winningTeam).append(" wins!").append("\n");

        model.addAttribute("matchResult :", result.toString());
        return "matchResult: "+result.toString();
    }

    @PostMapping("/startMatch")
    public void startMatch(@RequestBody MatchEntity match) {
        // Initialize the match with two teams and other details
    }

    @GetMapping("/runMatch")
    public void runMatch() {
        // Implement the logic to simulate the match using the CricketGameService
    }
}
