package com.example.designpatterns.headfirst.decorator

abstract class Beverage {
    abstract fun cost(): Double
    abstract fun description(): String
}

class DarkRoast : Beverage() {
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
        return .15 + beverage.cost()
    }

    override fun description(): String = "${beverage.description()}, Soy"

}


