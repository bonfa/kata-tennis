package it.fbonfadelli

class ScoreFormatter {
    private val basicPoints = mapOf(0 to "Love", 1 to "15", 2 to "30", 3 to "40")

    fun formatScore(score: GameScore): String =
        when (score) {
            WinPlayerB -> "Player B win"
            WinPlayerA -> "Player A win"
            AdvantagePlayerA -> "Player A advantage"
            AdvantagePlayerB -> "Player B advantage"
            Deuce -> "Deuce"
            is NormalScore -> "${basicPoints[score.playerAScore]!!} - ${basicPoints[score.playerBScore]!!}"
        }
}