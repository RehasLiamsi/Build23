package org.example.tennis;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

public class Tennis {
    private Map<String, Integer> scores = new HashMap<>();

    public Tennis(){
        scores.put("player1",0);
        scores.put("player2",0);
    }

    public String readScore() {
        int player1Score = scores.get("player1");
        int player2Score = scores.get("player2");
        String scoreAsString = "";


        scoreAsString += getScore(player1Score);
        scoreAsString += "-";
        scoreAsString += getScore(player2Score);
        return scoreAsString;
    }

    @NotNull
    private static String getScore(int playerScore) {
        if(playerScore == 2)
            return "30";
        else if(playerScore == 1)
            return "15";
        else
            return "love";
    }

    public void incrementScore(String player) {
        scores.put(player, scores.get(player) + 1);
    }
}
