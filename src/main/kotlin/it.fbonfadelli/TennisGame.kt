package it.fbonfadelli

class TennisGame {

    private var playerBScore: Int = 0
    private var playerAScore: Int = 0

    fun playerAScores() {
        playerAScore++
    }

    fun playerBScores() {
        playerBScore++
    }

    fun getScore(): String {
        return getScore2(playerAScore, playerBScore)
    }

    companion object {
        private val basicPoints = mapOf(0 to "Love", 1 to "15", 2 to "30", 3 to "40")
        private fun getScore2(playerAScore: Int, playerBScore: Int): String {
            if (playerBScore > 3 && playerBScore - playerAScore > 1)
                return "Player B win"
            if (playerAScore > 3 && playerAScore - playerBScore > 1)
                return "Player A win"
            if (playerAScore > 3 && playerAScore - 1 == playerBScore)
                return "Player A advantage"
            if (playerBScore > 3 && playerBScore - 1 == playerAScore)
                return "Player B advantage"
            if (playerAScore == playerBScore && playerAScore > 2)
                return "Deuce"
            return basicPoints[playerAScore]!! + " - " + basicPoints[playerBScore]!!
        }
    }
}
