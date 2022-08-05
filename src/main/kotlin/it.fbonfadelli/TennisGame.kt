package it.fbonfadelli

class TennisGame {
    private var playerAScore: Int = 0

    fun getPlayerAScore(): String {
        if (playerAScore == 0)
            return "Love"
        return "15"
    }

    fun playerAScores() {
        playerAScore = 1;
    }

}
