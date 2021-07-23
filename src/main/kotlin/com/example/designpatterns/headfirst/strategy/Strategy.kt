package com.example.designpatterns.headfirst.strategy

fun main() {
    val contextAdd = Context(OperationAdd())
    val contextMultiply = Context(OperationMultiply())

    println(contextAdd.execute(1, 2))
    println(contextMultiply.execute(3, 2))

    val contextFnSum = ContextFn { x: Int, y: Int -> x + y }
    val contextFnMultiply = ContextFn { x: Int, y: Int -> x * y }
    val contextFnSubtraction = ContextFn { x: Int, y: Int -> x - y }

    println(contextFnSum.execute(1, 2))
    println(contextFnMultiply.execute(3, 2))
    println(contextFnSubtraction.execute(3, 2))
}