package it.fbonfadelli

class TennisGame {
    private val basicPoints = mapOf(0 to "Love", 1 to "15", 2 to "30", 3 to "40")

    private var playerBScore: Int = 0
    private var playerAScore: Int = 0

    fun playerAScores() {
        playerAScore++
    }

    fun playerBScores() {
        playerBScore++
    }

    fun getScore(): String {
        if (playerAScore > 3 && playerAScore - 1 == playerBScore)
            return "Player A advantage"
        if (playerAScore == playerBScore && playerAScore > 2)
            return "Deuce"
        return basicPoints[playerAScore]!! + " - " + basicPoints[playerBScore]!!
    }


}
