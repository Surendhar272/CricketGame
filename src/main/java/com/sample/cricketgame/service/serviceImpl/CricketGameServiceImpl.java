package com.sample.cricketgame.service.serviceImpl;

import com.sample.cricketgame.service.CricketGameService;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class CricketGameServiceImpl implements CricketGameService {
    private static final String[] OUTCOMES = {"0", "1", "2", "3", "4", "5", "6", "W"};
    private Random random = new Random();

    public String playBall() {
        int randomIndex = random.nextInt(OUTCOMES.length);
        return OUTCOMES[randomIndex];
    }
}
