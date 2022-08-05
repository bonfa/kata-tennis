package it.fbonfadelli

class TennisGame {
    private var score = Score()

    fun playerAScores() {
        score = score.playerAScoresOnePoint()
    }

    fun playerBScores() {
        score = score.playerBScoresOnePoint()
    }

    fun getScore(): String {
        return getScore2(score)
    }

    companion object {
        private fun getScore2(score: Score): String =
            when {
                score.playerBScore > 3 && score.playerBScore - score.playerAScore > 1 -> "Player B win"
                score.playerAScore > 3 && score.playerAScore - score.playerBScore > 1 -> "Player A win"
                score.playerAScore > 3 && score.playerAScore - 1 == score.playerBScore -> "Player A advantage"
                score.playerBScore > 3 && score.playerBScore - 1 == score.playerAScore -> "Player B advantage"
                score.playerAScore == score.playerBScore && score.playerAScore > 2 -> "Deuce"
                else -> {
                    val basicPoints = mapOf(0 to "Love", 1 to "15", 2 to "30", 3 to "40")
                    basicPoints[score.playerAScore]!! + " - " + basicPoints[score.playerBScore]!!
                }
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
