package `class`

abstract class General {
    var wins: Int = 0
    var losses: Int = 0
    var ties: Int = 0
    val numMatch: Int
    get() = wins + losses + ties
    abstract val name: String
    abstract fun action(): String

    fun printStatus() {
        println("$name have played $numMatch match(es), with the record of $wins win(s), $losses loss(es) and $ties tie(s)")
    }
}