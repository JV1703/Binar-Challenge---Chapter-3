package `class`

import choices

class Human(name_param: String) : General() {
    override val name: String = name_param
    override fun action(): String {
        println("Please select a number from $choices")
        val pick = readLine() ?: ""
        return pick
    }
}

class Computer : General() {
    override val name: String = "Computer"
    override fun action(): String {
        return (1..choices.size).random().toString()
    }
}