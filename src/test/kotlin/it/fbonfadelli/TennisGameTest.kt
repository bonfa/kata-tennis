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

    @Test
    internal fun `playerB - zero`() {
        assertThat(tennisGame.getPlayerBScore()).isEqualTo("Love")
    }

    @Test
    internal fun `playerB - 15`() {
        tennisGame.playerBScores()

        assertThat(tennisGame.getPlayerBScore()).isEqualTo("15")
    }

    @Test
    internal fun `playerB - 30`() {
        tennisGame.playerBScores()
        tennisGame.playerBScores()

        assertThat(tennisGame.getPlayerBScore()).isEqualTo("30")
    }

    @Test
    internal fun `playerB - 40`() {
        tennisGame.playerBScores()
        tennisGame.playerBScores()
        tennisGame.playerBScores()

        assertThat(tennisGame.getPlayerBScore()).isEqualTo("40")
    }

    @Test
    internal fun `15 - 0`() {
        tennisGame.playerAScores()

        assertThat(tennisGame.getScore()).isEqualTo("15 - Love")
    }

    @Test
    internal fun `30 - 0`() {
        tennisGame.playerAScores()
        tennisGame.playerAScores()

        assertThat(tennisGame.getScore()).isEqualTo("30 - Love")
    }
}