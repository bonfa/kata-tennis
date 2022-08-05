package it.fbonfadelli

class TennisGame {
    private val basicPoints = mapOf(0 to "Love", 1 to "15", 2 to "30", 3 to "40")
    private var playerAScore: Int = 0

    fun getPlayerAScore(): String {
        return basicPoints[playerAScore]!!
    }

    fun playerAScores() {
        playerAScore++
    }

}
