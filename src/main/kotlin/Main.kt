import `class`.Computer
import `class`.Human

fun main() {
    println("Hi! Welcome to the game! Please input your name:")
    var nameInput = readLine() ?: ""

    val player = Human(nameInput)
    val computer = Computer()

    playGame(player, computer)
}

val choices: Map<String, String> = mapOf("1" to "Rock", "2" to "Paper", "3" to "Scissors")


fun playGame(player: Human, computer: Computer) {
    var output: String = ""
    val playerMove = player.action()
    val computerMove = computer.action()

    if (playerMove == computerMove) {
        println("${player.name} played ${choices[playerMove]} and ${computer.name} played ${choices[computerMove]}. Tie Game")
    }else if (playerMove == "1" && computerMove == "3" || playerMove == "2" && computerMove == "1" || playerMove == "3" && computerMove == "2") {
        println("${player.name} played ${choices[playerMove]} and ${computer.name} played ${choices[computerMove]}. Congratulations! You Win")
    } else {
        println("${player.name} played ${choices[playerMove]} and ${computer.name} played ${choices[computerMove]}. You Lose")
    }
}