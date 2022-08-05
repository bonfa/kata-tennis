package it.fbonfadelli

class TennisGame {
    private var gameScore: GameScore = NormalScore()

    fun playerAScores() {
        gameScore = gameScore.playerAScores()
    }

    fun playerBScores() {
        gameScore = gameScore.playerBScores()
    }

    fun getScore(): String = formatScore(gameScore)

    companion object {
        private val basicPoints = mapOf(0 to "Love", 1 to "15", 2 to "30", 3 to "40")

        private fun formatScore(score: GameScore): String = when (score) {
            WinPlayerB -> "Player B win"
            WinPlayerA -> "Player A win"
            AdvantagePlayerA -> "Player A advantage"
            AdvantagePlayerB -> "Player B advantage"
            Deuce -> "Deuce"
            is NormalScore -> basicPoints[score.playerAScore]!! + " - " + basicPoints[score.playerBScore]!!
        }
    }
}

sealed interface GameScore {
    fun playerAScores(): GameScore
    fun playerBScores(): GameScore
}

object AdvantagePlayerA : GameScore {
    override fun playerAScores(): GameScore = WinPlayerA
    override fun playerBScores(): GameScore = Deuce
}

object AdvantagePlayerB : GameScore {
    override fun playerAScores(): GameScore = Deuce
    override fun playerBScores(): GameScore = WinPlayerB
}

object WinPlayerA : GameScore {
    override fun playerAScores(): GameScore = throw UnsupportedOperationException()
    override fun playerBScores(): GameScore = throw UnsupportedOperationException()
}

object WinPlayerB : GameScore {
    override fun playerAScores(): GameScore = throw UnsupportedOperationException()
    override fun playerBScores(): GameScore = throw UnsupportedOperationException()
}

object Deuce : GameScore {
    override fun playerAScores(): GameScore = AdvantagePlayerA
    override fun playerBScores(): GameScore = AdvantagePlayerB
}

class NormalScore(
    val playerAScore: Int = 0,
    val playerBScore: Int = 0
) : GameScore {
    override fun playerAScores(): GameScore =
        when {
            playerAScore == 2 && playerBScore == 3 -> Deuce
            playerAScore == 3 -> WinPlayerA
            else -> NormalScore(playerAScore + 1, playerBScore)
        }

    override fun playerBScores(): GameScore =
        when {
            playerAScore == 3 && playerBScore == 2 -> Deuce
            playerBScore == 3 -> WinPlayerB
            else -> NormalScore(playerAScore, playerBScore + 1)
        }
}
