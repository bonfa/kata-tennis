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
        return getScore2(Score(playerAScore, playerBScore))
    }

    companion object {
        private val basicPoints = mapOf(0 to "Love", 1 to "15", 2 to "30", 3 to "40")
        private fun getScore2(score: Score): String {
            return if (score.playerBScore > 3 && score.playerBScore - score.playerAScore > 1)
                "Player B win"
            else if (score.playerAScore > 3 && score.playerAScore - score.playerBScore > 1)
                "Player A win"
            else if (score.playerAScore > 3 && score.playerAScore - 1 == score.playerBScore)
                "Player A advantage"
            else if (score.playerBScore > 3 && score.playerBScore - 1 == score.playerAScore)
                "Player B advantage"
            else if (score.playerAScore == score.playerBScore && score.playerAScore > 2)
                "Deuce"
            else
                basicPoints[score.playerAScore]!! + " - " + basicPoints[score.playerBScore]!!
        }
    }
}

data class Score(val playerAScore: Int = 0, val playerBScore: Int = 0) {
    fun playerAScoresOnePoint(): Score {
        return Score(playerAScore + 1, playerBScore)
    }

    fun playerBScoresOnePoint(): Score {
        return Score(playerAScore, playerBScore + 1)
    }
}
