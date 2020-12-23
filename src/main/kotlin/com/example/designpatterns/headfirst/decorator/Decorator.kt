package com.example.designpatterns.headfirst.decorator

fun main() {
    val darkRoast: Beverage = DarkRoast()
    println("${darkRoast.description()} $ ${darkRoast.cost()}")

    val houseBlend: Beverage = HouseBlend()
    val mocha = Mocha(houseBlend)
    val extraMocha = Mocha(Mocha(houseBlend))
    val soy = Soy(darkRoast)
    println("${mocha.description()} $ ${mocha.cost()}")
    println("${extraMocha.description()} $ ${extraMocha.cost()}")
    println("${soy.description()} $ ${soy.cost()}")

}