package com.example.designpatterns.headfirst.decorator

fun main() {
    println("**Imperative**")
    val darkRoast: Beverage = DarkRoast()
    println("${darkRoast.description()} $ ${darkRoast.cost()}")

    val houseBlend: Beverage = HouseBlend()
    val mocha = Mocha(houseBlend)
    val extraMocha = Mocha(Mocha(houseBlend))
    val soy = Soy(darkRoast)
    println("${mocha.description()} $ ${mocha.cost()}")
    println("${extraMocha.description()} $ ${extraMocha.cost()}")
    println("${soy.description()} $ ${soy.cost()}")

    val soyUltraBig = Soy(DarkRoast(Size.ULTRA_BIG))
    println("${soyUltraBig.description()} $ ${soyUltraBig.cost()}")

    println("**Functional**")
    val darkRoastFn = makeDarkRoast()
    println("${darkRoastFn.description} $ ${darkRoastFn.cost}")
    val mochaFn = darkRoastFn.decorate { addMocha(it) }
    println("${mochaFn.description} $ ${mochaFn.cost}")
    val extraMochaFn = darkRoastFn.decorate { addMocha(it) }.decorate { addMocha(it) }
    println("${extraMochaFn.description} $ ${extraMochaFn.cost}")
    val soyFn = darkRoastFn.decorate { addSoy(it) }
    val soyUltraBigFn = makeDarkRoast(Size.ULTRA_BIG).decorate { addSoy(it) }
    println("${soyFn.description} $ ${soyFn.cost}")
    println("${soyUltraBigFn.description} $ ${soyUltraBigFn.cost}")

}