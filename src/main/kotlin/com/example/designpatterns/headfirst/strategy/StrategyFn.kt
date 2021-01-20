package com.example.designpatterns.headfirst.strategy

class ContextFn(private val fn: (a: Int, b: Int) -> Int) {

    fun execute(n1: Int, n2: Int) = fn.invoke(n1, n2)

}