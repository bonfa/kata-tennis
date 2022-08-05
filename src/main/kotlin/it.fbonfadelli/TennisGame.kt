package it.fbonfadelli

class TennisGame {
    private var playerAScore: Int = 0

    fun getPlayerAScore(): String {
        if (playerAScore == 0)
            return "Love"
        if (playerAScore == 1)
            return "15"
        return "30"
    }

    fun playerAScores() {
        playerAScore++;
    }

}
