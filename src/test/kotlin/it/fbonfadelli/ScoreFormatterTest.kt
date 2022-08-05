package it.fbonfadelli

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ScoreFormatterTest {
    private val scoreFormatter = ScoreFormatter()

    @Test
    fun advantagePlayerA() {
        val score = AdvantagePlayerA

        val result = scoreFormatter.formatScore(score)

        assertThat(result).isEqualTo("Player A advantage")
    }

    @Test
    fun advantagePlayerB() {
        val score = AdvantagePlayerB

        val result = scoreFormatter.formatScore(score)

        assertThat(result).isEqualTo("Player B advantage")
    }

    @Test
    fun winPlayerA() {
        val score = WinPlayerA

        val result = scoreFormatter.formatScore(score)

        assertThat(result).isEqualTo("Player A win")
    }

    @Test
    fun winPlayerB() {
        val score = WinPlayerB

        val result = scoreFormatter.formatScore(score)

        assertThat(result).isEqualTo("Player B win")
    }

    @Test
    fun deuce() {
        val score = Deuce

        val result = scoreFormatter.formatScore(score)

        assertThat(result).isEqualTo("Deuce")
    }

    @Test
    fun normal_0_0() {
        val score = NormalScore()

        val result = scoreFormatter.formatScore(score)

        assertThat(result).isEqualTo("Love - Love")
    }

    @Test
    fun normal_15_0() {
        val score = NormalScore(1, 0)

        val result = scoreFormatter.formatScore(score)

        assertThat(result).isEqualTo("15 - Love")
    }

    @Test
    fun normal_30_0() {
        val score = NormalScore(2, 0)

        val result = scoreFormatter.formatScore(score)

        assertThat(result).isEqualTo("30 - Love")
    }

    @Test
    fun normal_40_0() {
        val score = NormalScore(3, 0)

        val result = scoreFormatter.formatScore(score)

        assertThat(result).isEqualTo("40 - Love")
    }

    @Test
    fun normal_0_15() {
        val score = NormalScore(0, 1)

        val result = scoreFormatter.formatScore(score)

        assertThat(result).isEqualTo("Love - 15")
    }

    @Test
    fun normal_0_30() {
        val score = NormalScore(0, 2)

        val result = scoreFormatter.formatScore(score)

        assertThat(result).isEqualTo("Love - 30")
    }

    @Test
    fun normal_0_40() {
        val score = NormalScore(0, 3)

        val result = scoreFormatter.formatScore(score)

        assertThat(result).isEqualTo("Love - 40")
    }
}