package com.example.designpatterns.headfirst.fp

import kotlin.math.sqrt

object PerfectNumbersFinder {
    fun factors(number: Int): ArrayList<Int> {
        val factors = arrayListOf(number, 1)

        for (i in 2..sqrt(number.toDouble()).toInt())
            if (number % i == 0) {
                factors.add(i)
                factors.add(number / i)
            }
        return factors

    }

    fun check(factors: ArrayList<Int>): Boolean {
        return factors.reduce { acc, i -> acc + i } - factors.first() == factors.first()
    }

}

