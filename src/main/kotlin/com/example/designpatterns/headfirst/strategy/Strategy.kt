package com.example.designpatterns.headfirst.strategy

fun main() {
    val context1 = Context(OperationAdd())
    val context2 = Context(OperationMultiply())

    println(context1.execute(1, 2))
    println(context2.execute(3, 2))
}