package it.fbonfadelli

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class GameScoreTest {

    interface GameScoreContract {
        fun playerAScores()
        fun playerBScores()
    }

    @Nested
    @DisplayName("advantage player A")
    inner class AdvantagePlayerATest : GameScoreContract {
        private val gameScore = AdvantagePlayerA

        @Test
        override fun playerAScores() {
            val result = gameScore.playerAScores()

            assertThat(result).isEqualTo(WinPlayerA)
        }

        @Test
        override fun playerBScores() {
            val result = gameScore.playerBScores()

            assertThat(result).isEqualTo(Deuce)
        }
    }

    @Nested
    @DisplayName("advantage player B")
    inner class AdvantagePlayerBTest : GameScoreContract {
        private val gameScore = AdvantagePlayerB

        @Test
        override fun playerAScores() {
            val result = gameScore.playerAScores()

            assertThat(result).isEqualTo(Deuce)
        }

        @Test
        override fun playerBScores() {
            val result = gameScore.playerBScores()

            assertThat(result).isEqualTo(WinPlayerB)
        }
    }

    @Nested
    @DisplayName("win player A")
    inner class WinPlayerATest : GameScoreContract {
        private val gameScore = WinPlayerA

        @Test
        override fun playerAScores() {
            assertThatThrownBy { gameScore.playerAScores() }
                .isInstanceOf(UnsupportedOperationException::class.java)
        }

        @Test
        override fun playerBScores() {
            assertThatThrownBy { gameScore.playerBScores() }
                .isInstanceOf(UnsupportedOperationException::class.java)
        }
    }

    @Nested
    @DisplayName("win player B")
    inner class WinPlayerBTest : GameScoreContract {
        private val gameScore = WinPlayerB

        @Test
        override fun playerAScores() {
            assertThatThrownBy { gameScore.playerAScores() }
                .isInstanceOf(UnsupportedOperationException::class.java)
        }

        @Test
        override fun playerBScores() {
            assertThatThrownBy { gameScore.playerBScores() }
                .isInstanceOf(UnsupportedOperationException::class.java)
        }
    }

    @Nested
    @DisplayName("deuce")
    inner class DeuceTest : GameScoreContract {
        private val gameScore = Deuce

        @Test
        override fun playerAScores() {
            val result = gameScore.playerAScores()

            assertThat(result).isEqualTo(AdvantagePlayerA)
        }

        @Test
        override fun playerBScores() {
            val result = gameScore.playerBScores()

            assertThat(result).isEqualTo(AdvantagePlayerB)
        }
    }

    //TODO: find a way to put it under inner class (now I have issues with companion objects for parametrized test)
    @ParameterizedTest
    @MethodSource("defaultScoresPlayerAScores")
    fun playerAScores(startingScore: GameScore, expected: GameScore) {
        val result = startingScore.playerAScores()

        assertThat(result).isEqualTo(expected)
    }

    @ParameterizedTest
    @MethodSource("defaultScoresPlayerBScores")
    fun playerBScores(startingScore: GameScore, expected: GameScore) {
        val result = startingScore.playerBScores()

        assertThat(result).isEqualTo(expected)
    }

    companion object {
        @JvmStatic
        fun defaultScoresPlayerAScores(): List<Arguments> =
            listOf(
                Arguments.of(NormalScore(0, 0), NormalScore(1, 0)),
                Arguments.of(NormalScore(0, 1), NormalScore(1, 1)),
                Arguments.of(NormalScore(0, 2), NormalScore(1, 2)),
                Arguments.of(NormalScore(0, 3), NormalScore(1, 3)),
                Arguments.of(NormalScore(1, 0), NormalScore(2, 0)),
                Arguments.of(NormalScore(1, 1), NormalScore(2, 1)),
                Arguments.of(NormalScore(1, 2), NormalScore(2, 2)),
                Arguments.of(NormalScore(1, 3), NormalScore(2, 3)),
                Arguments.of(NormalScore(2, 0), NormalScore(3, 0)),
                Arguments.of(NormalScore(2, 1), NormalScore(3, 1)),
                Arguments.of(NormalScore(2, 2), NormalScore(3, 2)),
                Arguments.of(NormalScore(2, 3), Deuce),
                Arguments.of(NormalScore(3, 0), WinPlayerA),
                Arguments.of(NormalScore(3, 1), WinPlayerA),
                Arguments.of(NormalScore(3, 2), WinPlayerA),
            )

        @JvmStatic
        fun defaultScoresPlayerBScores(): List<Arguments> =
            listOf(
                Arguments.of(NormalScore(0, 0), NormalScore(0, 1)),
                Arguments.of(NormalScore(0, 1), NormalScore(0, 2)),
                Arguments.of(NormalScore(0, 2), NormalScore(0, 3)),
                Arguments.of(NormalScore(0, 3), WinPlayerB),
                Arguments.of(NormalScore(1, 0), NormalScore(1, 1)),
                Arguments.of(NormalScore(1, 1), NormalScore(1, 2)),
                Arguments.of(NormalScore(1, 2), NormalScore(1, 3)),
                Arguments.of(NormalScore(1, 3), WinPlayerB),
                Arguments.of(NormalScore(2, 0), NormalScore(2, 1)),
                Arguments.of(NormalScore(2, 1), NormalScore(2, 2)),
                Arguments.of(NormalScore(2, 2), NormalScore(2, 3)),
                Arguments.of(NormalScore(2, 3), WinPlayerB),
                Arguments.of(NormalScore(3, 0), NormalScore(3, 1)),
                Arguments.of(NormalScore(3, 1), NormalScore(3, 2)),
                Arguments.of(NormalScore(3, 2), Deuce),
            )
    }
}