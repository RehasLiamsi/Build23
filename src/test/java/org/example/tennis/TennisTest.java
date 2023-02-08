package org.example.tennis;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

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

    @Test
    void afterPlayersHaveWonOneBallEachScoreShouldBe1515() {
        Tennis tennis = new Tennis();

        tennis.incrementScore("player1");
        tennis.incrementScore("player2");

        assertThat(tennis.readScore()).isEqualTo("15-15");
    }

    @Test
    void afterPlayer1HasWonTwoBallsScoreShouldBe30love() {
        Tennis tennis = new Tennis();

        tennis.incrementScore("player1");
        tennis.incrementScore("player1");

        assertThat(tennis.readScore()).isEqualTo("30-love");
    }

    @Test
    void afterPlayer1HasWonThreeBallsScoreShouldBe40love() {
        Tennis tennis = new Tennis();

        tennis.incrementScore("player1");
        tennis.incrementScore("player1");
        tennis.incrementScore("player1");

        assertThat(tennis.readScore()).isEqualTo("40-love");
    }

    @Test
    void playerThatHasWom3BallsAndWinsAnotherShouldWinTheGame() {
        Tennis tennis = new Tennis();

        tennis.incrementScore("player1");
        tennis.incrementScore("player1");
        tennis.incrementScore("player1");
        tennis.incrementScore("player1");

        assertThat(tennis.isGameOver()).isTrue();
    }

    @Test
    void whenBothPlayersHaveWon3BallsPlayer1ShouldNotWinAfterOneMoreBall() {
        Tennis tennis = new Tennis();

        tennis.incrementScore("player1");
        tennis.incrementScore("player1");
        tennis.incrementScore("player1");
        tennis.incrementScore("player2");
        tennis.incrementScore("player2");
        tennis.incrementScore("player2");
        tennis.incrementScore("player1");

        assertThat(tennis.isGameOver()).isFalse();
    }

    @Test
    void whenOnePlayerHasWon2MoreBallsThanTheOtherGameIsOver() {
        Tennis tennis = new Tennis();

        tennis.incrementScore("player1");
        tennis.incrementScore("player1");
        tennis.incrementScore("player2");
        tennis.incrementScore("player2");
        tennis.incrementScore("player1");
        tennis.incrementScore("player2");
        tennis.incrementScore("player1");
        tennis.incrementScore("player1");

        assertThat(tennis.isGameOver()).isTrue();
    }

    @Test
    void whenBothPlayersHaveScoredAtLeast3BallsAndTheyHaveSameScoreShouldBeDeuce() {
        Tennis tennis = new Tennis();

        tennis.incrementScore("player1");
        tennis.incrementScore("player1");
        tennis.incrementScore("player1");
        tennis.incrementScore("player2");
        tennis.incrementScore("player2");
        tennis.incrementScore("player2");

        assertThat(tennis.readScore()).isEqualTo("deuce");
        assertThat(tennis.isGameOver()).isFalse();
    }
}
