import `class`.Computer
import `class`.Human

fun main() {
    println("Hi! Welcome to the game! Please input your name:")
    var nameInput = readLine() ?: ""

    val player = Human(nameInput)
    val computer = Computer()
}

val choices: Map<String, String> = mapOf("1" to "Rock", "2" to "Paper", "3" to "Scissors")