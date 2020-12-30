package com.example.designpatterns.headfirst.command

class Directions {
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

interface Direction {
    fun execute()
}

class TurnRightDirection(private val directions: Directions) : Direction {
    override fun execute() {
        directions.turnRight()
    }
}

class TurnLeftDirection(private val directions: Directions) : Direction {
    override fun execute() {
        directions.turnLeft()
    }
}

class UpDirection(private val directions: Directions) : Direction {
    override fun execute() {
        directions.up()
    }
}

class DownDirection(private val directions: Directions) : Direction {
    override fun execute() {
        directions.down()
    }
}

class Instructions(private val directions: List<Direction>) {

    fun run() {
        directions.forEach {
            it.execute()
        }
    }
}