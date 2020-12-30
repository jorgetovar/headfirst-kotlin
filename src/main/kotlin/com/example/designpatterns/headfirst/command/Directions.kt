package com.example.designpatterns.headfirst.command

class Directions() {
    fun turnRight() {
        println("right")
    }

    fun turnLeft() {
        println("left")
    }

    fun up() {
        println("up")
    }

    fun down() {
        println("down")
    }
}

interface Command {
    fun execute()
}

class TurnRightCommand(private val directions: Directions) : Command {
    override fun execute() {
        directions.turnRight()
    }
}

class TurnLeftCommand(private val directions: Directions) : Command {
    override fun execute() {
        directions.turnLeft()
    }
}

class UpCommand(private val directions: Directions) : Command {
    override fun execute() {
        directions.up()
    }
}

class DownCommand(private val directions: Directions) : Command {
    override fun execute() {
        directions.down()
    }
}

class Instructions(private val commands: List<Command>) {

    fun run() {
        commands.forEach {
            it.execute()
        }
    }
}