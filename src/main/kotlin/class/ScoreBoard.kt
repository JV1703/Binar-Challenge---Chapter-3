package `class`

interface ScoreBoard {
    var wins: Int
    var losses: Int
    var ties: Int
    val numMatch: Int
        get() = wins + losses + ties
}