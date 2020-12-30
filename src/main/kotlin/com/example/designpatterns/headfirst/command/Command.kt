package com.example.designpatterns.headfirst.command

fun main() {
    val directions = Directions()
    val turnLeftCommand = TurnLeftDirection(directions)
    val turnRightCommand = TurnRightDirection(directions)
    val turnRightCommandAgain = TurnRightDirection(directions)
    val upCommand = UpDirection(directions)

    val instructions = Instructions(listOf(turnLeftCommand, turnRightCommand, turnRightCommandAgain, upCommand))
    instructions.run()
}