package com.example.designpatterns.headfirst.strategy

interface Strategy {
    fun doOperation(num1: Int, num2: Int): Int
}

class OperationAdd : Strategy {
    override fun doOperation(num1: Int, num2: Int): Int {
        return num1 + num2
    }
}

class OperationMultiply : Strategy {
    override fun doOperation(num1: Int, num2: Int): Int {
        return num1 * num2
    }
}

class Context(private val strategy: Strategy) {

    fun execute(num1: Int, num2: Int): Int {
        return strategy.doOperation(num1, num2)
    }
}