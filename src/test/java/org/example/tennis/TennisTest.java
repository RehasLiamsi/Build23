package org.example.tennis;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

import static org.assertj.core.api.Assertions.*;

public class TennisTest {

    private final Tennis tennis = new Tennis();

    @Test
    void newTennisObjectHasScoreLoveLove() {
        assertThat(tennis.readScore()).isEqualTo("love-love");
    }

    @Test
    void afterPlayer1WinsBallScoreShouldBe15Love() {
        tennis.incrementScore("player1");

        assertThat(tennis.readScore()).isEqualTo("15-love");
    }

    @Test
    void afterPlayersHaveWonOneBallEachScoreShouldBe1515() {
        tennis.incrementScore("player1");
        tennis.incrementScore("player2");

        assertThat(tennis.readScore()).isEqualTo("15-15");
    }

    @Test
    void afterPlayer1HasWonTwoBallsScoreShouldBe30love() {

        tennis.incrementScore("player1");
        tennis.incrementScore("player1");

        assertThat(tennis.readScore()).isEqualTo("30-love");
    }

    @Test
    void afterPlayer1HasWonThreeBallsScoreShouldBe40love() {

        tennis.incrementScore("player1");
        tennis.incrementScore("player1");
        tennis.incrementScore("player1");

        assertThat(tennis.readScore()).isEqualTo("40-love");
    }

    @Test
    void playerThatHasWom3BallsAndWinsAnotherShouldWinTheGame() {

        tennis.incrementScore("player1");
        tennis.incrementScore("player1");
        tennis.incrementScore("player1");
        tennis.incrementScore("player1");

        assertThat(tennis.isGameOver()).isTrue();
    }

    @Test
    void whenBothPlayersHaveWon3BallsPlayer1ShouldNotWinAfterOneMoreBall() {

        play40_40();
        tennis.incrementScore("player1");

        assertThat(tennis.isGameOver()).isFalse();
    }

    @Test
    void whenOnePlayerHasWon2MoreBallsThanTheOtherGameIsOver() {

        play40_40();

        tennis.incrementScore("player1");
        tennis.incrementScore("player1");

        assertThat(tennis.isGameOver()).isTrue();
    }

    @Test
    void whenBothPlayersHaveScoredAtLeast3BallsAndTheyHaveSameScoreShouldBeDeuce() {

        play40_40();

        assertThat(tennis.readScore()).isEqualTo("deuce");
        assertThat(tennis.isGameOver()).isFalse();
    }

    @Test
    void whenBothPlayersHaveSameScoreAndMoreThan3BallsShouldBeDeuce() {

        play40_40();
        tennis.incrementScore("player1");
        tennis.incrementScore("player2");

        assertThat(tennis.readScore()).isEqualTo("deuce");
        assertThat(tennis.isGameOver()).isFalse();
    }

    @Test
    void whenBothPlayersHaveMoreThan3BallsAndPlayer1HasAnAdvantageOfOneShouldBeAdvantagePlayerName() {

        play40_40();
        tennis.incrementScore("player1");
        tennis.incrementScore("player2");
        tennis.incrementScore("player1");

        assertThat(tennis.readScore()).isEqualTo("advantage player1");
        assertThat(tennis.isGameOver()).isFalse();
    }

    @Test
    void whenBothPlayersHaveMoreThan3BallsAndPlayer2HasAnAdvantageOfOneShouldBeAdvantagePlayerName() {

        play40_40();
        tennis.incrementScore("player1");
        tennis.incrementScore("player2");
        tennis.incrementScore("player2");

        assertThat(tennis.readScore()).isEqualTo("advantage player2");
        assertThat(tennis.isGameOver()).isFalse();
    }

    @Test
    void playCompleteRound() {
        assertThat(tennis.readScore()).isEqualTo("love-love");
        tennis.incrementScore("player1");
        assertThat(tennis.readScore()).isEqualTo("15-love");
        tennis.incrementScore("player1");
        assertThat(tennis.readScore()).isEqualTo("30-love");
        tennis.incrementScore("player2");
        assertThat(tennis.readScore()).isEqualTo("30-15");
        tennis.incrementScore("player1");
        assertThat(tennis.readScore()).isEqualTo("40-15");
        tennis.incrementScore("player2");
        assertThat(tennis.readScore()).isEqualTo("40-30");
        tennis.incrementScore("player2");
        assertThat(tennis.readScore()).isEqualTo("deuce");
        tennis.incrementScore("player1");
        assertThat(tennis.readScore()).isEqualTo("advantage player1");
        assertThat(tennis.isGameOver()).isFalse();
        tennis.incrementScore("player2");
        assertThat(tennis.readScore()).isEqualTo("deuce");
        tennis.incrementScore("player2");
        assertThat(tennis.readScore()).isEqualTo("advantage player2");
        tennis.incrementScore("player2");
        assertThat(tennis.readScore()).isEqualTo("winner player2");
        assertThat(tennis.isGameOver()).isTrue();

    }

    @Test
    void callingIncrementScoreWhenGameIsOverThrowsException() {
        tennis.incrementScore("player1");
        tennis.incrementScore("player1");
        tennis.incrementScore("player1");
        tennis.incrementScore("player1");

        assertThatThrownBy(() -> tennis.incrementScore("player1"))
                .isInstanceOf(IllegalStateException.class);
    }

    private void play40_40() {
        tennis.incrementScore("player1");
        tennis.incrementScore("player1");
        tennis.incrementScore("player1");
        tennis.incrementScore("player2");
        tennis.incrementScore("player2");
        tennis.incrementScore("player2");
    }
}
