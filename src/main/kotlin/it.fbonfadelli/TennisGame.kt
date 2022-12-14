package it.fbonfadelli

class TennisGame(private val scoreFormatter: ScoreFormatter) {

    private var gameScore: GameScore = DefaultScore()

    fun playerAScores() {
        gameScore = gameScore.playerAScores()
    }

    fun playerBScores() {
        gameScore = gameScore.playerBScores()
    }

    fun getScore(): String = scoreFormatter.formatScore(gameScore)
}


