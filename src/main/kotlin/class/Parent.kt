package `class`

abstract class Player : ScoreBoard {
    override var wins = 0
    override var losses = 0
    override var ties = 0

    abstract val name: String
    abstract fun action(): String

    fun printStatus() {
        println("$name have played $numMatch match(es), with the record of $wins win(s), $losses loss(es) and $ties tie(s)")
    }
}