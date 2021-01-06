package com.example.designpatterns.headfirst.iterator

data class MenuItem(val name: String, val price: Double, val description: String = "", val vegetarian: Boolean = false)

class PancakeHouseMenu(val menuItems: List<MenuItem>)

class DinerMenu(val menuItems: Array<MenuItem>)

