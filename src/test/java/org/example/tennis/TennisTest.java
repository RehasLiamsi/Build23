package org.example.tennis;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TennisTest {

    @Test
    void newTennisObjectHasScoreLoveLove() {
        Tennis tennis = new Tennis();

        assertThat(tennis.readScore()).isEqualTo("love-love");
    }

    @Test
    void afterPlayer1WinsBallScoreShouldBe15Love() {
        Tennis tennis = new Tennis();

        tennis.incrementScore("player1");

        assertThat(tennis.readScore()).isEqualTo("15-love");
    }
}
