package exceptiontest

import choices


class BadName : IllegalArgumentException()
fun testName(input: String) {
    if (input.isBlank()) {
        throw BadName()
    }
}


class BadMove : IllegalArgumentException()
fun testMove(input: String) {
    if (input.isBlank() || !choices.containsKey(input)) {
        throw BadMove()
    }
}


class BadReply : IllegalArgumentException()
fun testReply(reply: String) {
    if (reply.isBlank() || reply != "y" && reply != "n") {
        throw BadReply()
    }
}