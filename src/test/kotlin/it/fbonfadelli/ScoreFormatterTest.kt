package it.fbonfadelli

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource


class ScoreFormatterTest {
    private val scoreFormatter = ScoreFormatter()

    @ParameterizedTest
    @MethodSource("arguments")
    fun simpleScores(score: GameScore, expected: String) {
        val result = scoreFormatter.formatScore(score)

        assertThat(result).isEqualTo(expected)
    }

    companion object {
        @JvmStatic
        fun arguments(): List<Arguments> {
            return listOf(
                Arguments.of(AdvantagePlayerA, "Player A advantage"),
                Arguments.of(AdvantagePlayerB, "Player B advantage"),
                Arguments.of(WinPlayerA, "Player A win"),
                Arguments.of(WinPlayerB, "Player B win"),
                Arguments.of(Deuce, "Deuce"),
                Arguments.of(DefaultScore(0, 0), "Love - Love"),
                Arguments.of(DefaultScore(1, 0), "15 - Love"),
                Arguments.of(DefaultScore(2, 0), "30 - Love"),
                Arguments.of(DefaultScore(3, 0), "40 - Love"),
                Arguments.of(DefaultScore(0, 1), "Love - 15"),
                Arguments.of(DefaultScore(0, 2), "Love - 30"),
                Arguments.of(DefaultScore(0, 3), "Love - 40"),
            )
        }
    }
}