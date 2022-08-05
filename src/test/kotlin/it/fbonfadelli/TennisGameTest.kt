package it.fbonfadelli

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

// Single Player
// Love-15-30-40 [x]

// Two players
// deuce
// advantage
// win

class TennisGameTest {
    private val tennisGame = TennisGame()

    @Test
    internal fun `playerA - zero`() {
        assertThat(tennisGame.getPlayerAScore()).isEqualTo("Love")
    }

    @Test
    internal fun `playerA - 15`() {
        tennisGame.playerAScores()

        assertThat(tennisGame.getPlayerAScore()).isEqualTo("15")
    }

    @Test
    internal fun `playerA - 30`() {
        tennisGame.playerAScores()
        tennisGame.playerAScores()

        assertThat(tennisGame.getPlayerAScore()).isEqualTo("30")
    }

    @Test
    internal fun `playerA - 40`() {
        tennisGame.playerAScores()
        tennisGame.playerAScores()
        tennisGame.playerAScores()

        assertThat(tennisGame.getPlayerAScore()).isEqualTo("40")
    }
}