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
}