import `class`.Computer
import `class`.Human
import exceptiontest.BadName
import exceptiontest.BadReply
import exceptiontest.testName
import exceptiontest.testReply
import java.util.*

fun main() {
//    get user name
    println("Hi! Welcome to the game! Please input your name:")
    lateinit var nameInput: String

//    Loop to make sure that user input valid name. ie. no blank name
    do {
        try {
            nameInput = readLine() ?: ""
            testName(nameInput)
        } catch (e: BadName) {
            println("Invalid input or user name exist. Please try again!")
        }
    } while (nameInput == "")

//    Instantiate Human class and Computer class
    val player = Human(nameInput)
    val computer = Computer()

//    determine if the game will continue(true) or end(false)
    var status = true

//    Repetitive game
    do {
        playGame(player, computer)
        println("continue? Y/N")
//        Loop to make sure use input valid entry. ie. no blank input and input value must be found in choices(map) key.
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

//    print game status upon end of game
    player.printStatus()
    computer.printStatus()

}

val choices: Map<String, String> = mapOf("1" to "Rock", "2" to "Paper", "3" to "Scissors")


fun playGame(player: Human, computer: Computer) {
    val playerMove = player.action()
    val computerMove = computer.action()

    if (playerMove == computerMove) {
        player.ties++
        computer.ties++
        println("${player.name} played ${choices[playerMove]} and ${computer.name} played ${choices[computerMove]}. Tie Game")
    } else if (playerMove == "1" && computerMove == "3" || playerMove == "2" && computerMove == "1" || playerMove == "3" && computerMove == "2") {
        player.wins++
        computer.losses++
        println("${player.name} played ${choices[playerMove]} and ${computer.name} played ${choices[computerMove]}. Congratulations! You Win")
    } else {
        player.losses++
        computer.wins++
        println("${player.name} played ${choices[playerMove]} and ${computer.name} played ${choices[computerMove]}. You Lose")
    }
}