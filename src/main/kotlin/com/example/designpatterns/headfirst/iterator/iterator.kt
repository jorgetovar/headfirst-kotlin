package com.example.designpatterns.headfirst.iterator


fun main() {
    val pancakeHouseMenu = PancakeHouseMenu(listOf(MenuItem("george", 2.0)))
    val dinerMenu = DinerMenu(arrayOf(MenuItem("george", 2.0),
            MenuItem("vegan", 2.0, vegetarian = true)))

    println("Pancake House Menu")

    pancakeHouseMenu.menuItems.forEach {
        println(it)
    }

    println("Diner Menu")

    dinerMenu.menuItems.forEach {
        println(it)
    }

    println("Diner Vegetarian Menu")
    dinerMenu.menuItems.filter {
        it.vegetarian
    }.forEach {
        println(it)
    }
}