package com.example.designpatterns.headfirst.fp

import kotlin.math.sqrt

object PerfectNumbersFinder {
    fun factors(number: Int): Boolean {
        val factors = arrayListOf(1, number)

        for (i in 2 .. sqrt(number.toDouble()).toInt())
            if (number % i == 0) {
                factors.add(i)
                factors.add(number / i)
            }
        val b = factors.reduce { acc, i -> acc + i } - number == number
        if (b) {
            println()
            println(factors)
        }
        return b
    }
}

