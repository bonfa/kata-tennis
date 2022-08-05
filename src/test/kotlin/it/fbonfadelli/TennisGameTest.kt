package it.fbonfadelli

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

// Single Player
// Love-15-30-40 [x]

// Two players [x]
// deuce [x]
// advantage
// win

class TennisGameTest {
    private val tennisGame = TennisGame()

    @Test
    internal fun `0 - 0`() {
        assertThat(tennisGame.getScore()).isEqualTo("Love - Love")
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

    @Test
    internal fun `40 - 0`() {
        tennisGame.playerAScores()
        tennisGame.playerAScores()
        tennisGame.playerAScores()

        assertThat(tennisGame.getScore()).isEqualTo("40 - Love")
    }

    @Test
    internal fun `0 - 15`() {
        tennisGame.playerBScores()

        assertThat(tennisGame.getScore()).isEqualTo("Love - 15")
    }

    @Test
    internal fun `0 - 30`() {
        tennisGame.playerBScores()
        tennisGame.playerBScores()

        assertThat(tennisGame.getScore()).isEqualTo("Love - 30")
    }

    @Test
    internal fun `0 - 40`() {
        tennisGame.playerBScores()
        tennisGame.playerBScores()
        tennisGame.playerBScores()

        assertThat(tennisGame.getScore()).isEqualTo("Love - 40")
    }

    @Test
    internal fun `40 - 40`() {
        tennisGame.playerAScores()
        tennisGame.playerAScores()
        tennisGame.playerAScores()

        tennisGame.playerBScores()
        tennisGame.playerBScores()
        tennisGame.playerBScores()

        assertThat(tennisGame.getScore()).isEqualTo("Deuce")
    }

    @Test
    internal fun `15 - 15`() {
        tennisGame.playerAScores()
        tennisGame.playerBScores()

        assertThat(tennisGame.getScore()).isEqualTo("15 - 15")
    }

    @Test
    internal fun `30 - 30`() {
        tennisGame.playerAScores()
        tennisGame.playerAScores()

        tennisGame.playerBScores()
        tennisGame.playerBScores()

        assertThat(tennisGame.getScore()).isEqualTo("30 - 30")
    }

    @Test
    internal fun `player A advantage`() {
        tennisGame.playerAScores()
        tennisGame.playerAScores()
        tennisGame.playerAScores()

        tennisGame.playerBScores()
        tennisGame.playerBScores()
        tennisGame.playerBScores()

        tennisGame.playerAScores()

        assertThat(tennisGame.getScore()).isEqualTo("Player A advantage")
    }

    @Test
    internal fun `player A advantage - for the second time`() {
        tennisGame.playerAScores()
        tennisGame.playerAScores()
        tennisGame.playerAScores()

        tennisGame.playerBScores()
        tennisGame.playerBScores()
        tennisGame.playerBScores()

        tennisGame.playerAScores()
        tennisGame.playerBScores()
        tennisGame.playerAScores()

        assertThat(tennisGame.getScore()).isEqualTo("Player A advantage")
    }

    @Test
    internal fun `player B advantage`() {
        tennisGame.playerAScores()
        tennisGame.playerAScores()
        tennisGame.playerAScores()

        tennisGame.playerBScores()
        tennisGame.playerBScores()
        tennisGame.playerBScores()

        tennisGame.playerBScores()

        assertThat(tennisGame.getScore()).isEqualTo("Player B advantage")
    }

    @Test
    internal fun `player B advantage - second time`() {
        tennisGame.playerAScores()
        tennisGame.playerAScores()
        tennisGame.playerAScores()

        tennisGame.playerBScores()
        tennisGame.playerBScores()
        tennisGame.playerBScores()

        tennisGame.playerBScores()
        tennisGame.playerAScores()
        tennisGame.playerBScores()

        assertThat(tennisGame.getScore()).isEqualTo("Player B advantage")
    }

}