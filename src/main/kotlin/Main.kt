import `class`.Computer
import `class`.Human
import exceptiontest.BadName
import exceptiontest.BadReply
import exceptiontest.testName
import exceptiontest.testReply
import java.util.*

fun main() {
    println("Hi! Welcome to the game! Please input your name:")
    lateinit var nameInput: String
    do {
        try {
            nameInput = readLine() ?: ""
            testName(nameInput)
        } catch (e: BadName) {
            println("Invalid input or user name exist. Please try again!")
        }
    } while (nameInput == "")

    val player = Human(nameInput)
    val computer = Computer()

    var status = true

    do {
        playGame(player, computer)
        println("continue? Y/N")
        do {
            try {
                val reply = readLine() ?: ""
                testReply(reply)
                if (reply.uppercase(Locale.getDefault()) == "N") status = false
                break
            } catch (e: BadReply) {
                println("Invalid input.")
                println("Would you like to play again? Y/N")
            }
        } while (true)
    } while (status)
}

val choices: Map<String, String> = mapOf("1" to "Rock", "2" to "Paper", "3" to "Scissors")


fun playGame(player: Human, computer: Computer) {
    var output: String = ""
    val playerMove = player.action()
    val computerMove = computer.action()

    if (playerMove == computerMove) {
        println("${player.name} played ${choices[playerMove]} and ${computer.name} played ${choices[computerMove]}. Tie Game")
    } else if (playerMove == "1" && computerMove == "3" || playerMove == "2" && computerMove == "1" || playerMove == "3" && computerMove == "2") {
        println("${player.name} played ${choices[playerMove]} and ${computer.name} played ${choices[computerMove]}. Congratulations! You Win")
    } else {
        println("${player.name} played ${choices[playerMove]} and ${computer.name} played ${choices[computerMove]}. You Lose")
    }
}