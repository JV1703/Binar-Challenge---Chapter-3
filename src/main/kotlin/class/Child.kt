package `class`

import choices
import exceptiontest.BadMove
import exceptiontest.testMove
import java.util.*

class Human(name_param: String) : General() {
    override val name: String = name_param
    override fun action(): String {
        println("Please select a number from: $choices")
        lateinit var pick: String
        do {
            try {
                pick = readLine() ?: ""
                testMove(pick.uppercase(Locale.getDefault()))
            } catch (e: BadMove) {
                println("Invalid choice. Please select a number from: $choices")
            }
        } while (!choices.containsKey(pick))

        return pick
    }
}

class Computer : General() {
    override val name: String = "Computer"
    override fun action(): String {
        return (1..choices.size).random().toString()
    }
}