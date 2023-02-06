package org.example.tennis;

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


        if(player1Score == 1)
            scoreAsString += "15";
        else
            scoreAsString += "love";
        scoreAsString += "-";
        if(player2Score == 1)
            scoreAsString += "15";
        else
            scoreAsString += "love";
        return scoreAsString;
    }

    public void incrementScore(String player) {
        scores.put(player, scores.get(player) + 1);
    }
}
