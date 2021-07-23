package com.example.designpatterns.headfirst.decorator

import arrow.optics.*

enum class Size {
    TALL, BIG, ULTRA_BIG
}

data class BeverageFn(val cost: Double, val description: String, val size: Size = Size.BIG) {
    fun decorate(fn: (a: BeverageFn) -> BeverageFn): BeverageFn {
        return fn.invoke(this)
    }
}

val beverageCost: Lens<BeverageFn, Double> = Lens(
        get = { b -> b.cost },
        set = { b, value -> b.copy(cost = value) }
)

val beverageDesc: Lens<BeverageFn, String> = Lens(
        get = { b -> b.description },
        set = { b, value -> b.copy(description = value) }
)

fun makeDarkRoast(size: Size = Size.TALL) = BeverageFn(.99, "Dark Roast Coffee", size)

fun addMocha(x: BeverageFn): BeverageFn {
    val mocha = beverageDesc.modify(x) { "$it, Mocha" }
    return beverageCost.modify(mocha) { it + .20 }
}

fun addSoy(x: BeverageFn): BeverageFn {
    val soy = beverageDesc.modify(x) { "$it, Soy" }
    return when (x.size) {
        Size.TALL -> beverageCost.modify(soy) { it + .10 }
        Size.BIG -> beverageCost.modify(soy) { it + .50 }
        Size.ULTRA_BIG -> beverageCost.modify(soy) { it + .20 }
    }
}

abstract class Beverage(val size: Size = Size.BIG) {
    abstract fun cost(): Double
    abstract fun description(): String
}




class DarkRoast(size: Size = Size.TALL) : Beverage(size) {
    override fun cost(): Double = .99
    override fun description() = "Dark Roast Coffee"
}

class HouseBlend : Beverage() {
    override fun cost(): Double = .89
    override fun description() = "House Blend Coffee"

}


abstract class CondimentDecorator(val beverage: Beverage) : Beverage()

class Mocha(beverage: Beverage) : CondimentDecorator(beverage) {

    override fun cost(): Double {
        return .20 + beverage.cost()
    }

    override fun description(): String = "${beverage.description()}, Mocha"
}

class Soy(beverage: Beverage) : CondimentDecorator(beverage) {

    override fun cost(): Double {

        return when (beverage.size) {
            Size.TALL -> .10 + beverage.cost()
            Size.BIG -> .15 + beverage.cost()
            Size.ULTRA_BIG -> .20 + beverage.cost()
        }
    }

    override fun description(): String = "${beverage.description()}, Soy"

}


