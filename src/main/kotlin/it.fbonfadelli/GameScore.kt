package it.fbonfadelli

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