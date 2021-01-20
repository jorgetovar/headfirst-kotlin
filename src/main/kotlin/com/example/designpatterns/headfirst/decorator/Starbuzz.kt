package com.example.designpatterns.headfirst.decorator

enum class Size {
    TALL, BIG, ULTRA_BIG
}

abstract class Beverage(val size: Size = Size.BIG) {
    abstract fun cost(): Double
    abstract fun description(): String
}

class BeverageFn(val cost: Double, val description: String, val size: Size = Size.BIG) {

    fun decorate(fn: (a: BeverageFn) -> BeverageFn): BeverageFn {
        return fn.invoke(this)
    }

}

fun makeDarkRoast(size: Size = Size.TALL) = BeverageFn(.99, "Dark Roast Coffee", size)

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


fun addMocha(x: BeverageFn): BeverageFn = BeverageFn(x.cost + .20, x.description + ", Mocha")

fun addSoy(x: BeverageFn): BeverageFn {
    val description = x.description + ", Soy"
    return when (x.size) {
        Size.TALL -> BeverageFn(x.cost + .10, description)
        Size.BIG -> BeverageFn(x.cost + .15, description)
        Size.ULTRA_BIG -> BeverageFn(x.cost + .20, description)
    }

}