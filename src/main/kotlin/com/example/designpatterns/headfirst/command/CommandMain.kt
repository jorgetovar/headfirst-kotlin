package com.example.designpatterns.headfirst.command

fun main() {
    val directions = Directions()
    val turnLeftCommand = TurnLeftCommand(directions)
    val turnRightCommand = TurnRightCommand(directions)
    val turnRightCommandAgain = TurnRightCommand(directions)
    val upCommand = UpCommand(directions)

    val instructions = Instructions(listOf(turnLeftCommand, turnRightCommand, turnRightCommandAgain, upCommand))
    instructions.run()
}