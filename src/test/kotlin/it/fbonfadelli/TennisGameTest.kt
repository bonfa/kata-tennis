package it.fbonfadelli

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

// Single Player
// Love-15-30-40

// Two players
// deuce
// advantage
// win

class TennisGameTest {

    @Test
    internal fun `start of the game`() {
        val tennisGame = TennisGame()
        assertThat(tennisGame.getPlayerAScore()).isEqualTo("Love")
    }

    @Test
    internal fun `playerA - 15`() {
        val tennisGame = TennisGame()

        tennisGame.playerAScores()

        assertThat(tennisGame.getPlayerAScore()).isEqualTo("15")
    }

    @Test
    internal fun `playerA - 30`() {
        val tennisGame = TennisGame()

        tennisGame.playerAScores()
        tennisGame.playerAScores()

        assertThat(tennisGame.getPlayerAScore()).isEqualTo("30")
    }

    @Test
    internal fun `playerA - 40`() {
        val tennisGame = TennisGame()

        tennisGame.playerAScores()
        tennisGame.playerAScores()
        tennisGame.playerAScores()

        assertThat(tennisGame.getPlayerAScore()).isEqualTo("40")
    }
}