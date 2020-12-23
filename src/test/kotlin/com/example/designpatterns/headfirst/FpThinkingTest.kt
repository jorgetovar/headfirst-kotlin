package com.example.designpatterns.headfirst

import com.example.designpatterns.headfirst.fp.PerfectNumbersFinder.check
import com.example.designpatterns.headfirst.fp.PerfectNumbersFinder.factors
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.CoreMatchers.`is`
import org.junit.jupiter.api.Test

class FpThinkingTest {

    private val perfectNumbers = listOf(6, 28, 496, 8128, 33550336)

    @Test
    fun perfectNumbersAllValid() {
        perfectNumbers.forEach {

            assertThat(check(factors(it)), `is`(true))
        }
    }

    @Test
    fun sixPerfectNumber() {
        assertThat(check(factors(6)), `is`(true))
    }

    @Test
    fun bigPerfectNumber() {

        assertThat(check(factors(33550336)), `is`(true))
    }

    @Test
    fun perfectNumbersTo100_000() {

        for (i in 2..100000) if (perfectNumbers.contains(i)) assertThat(check(factors(i)), `is`(true))
        else assertThat(check(factors(i)), `is`(false))
    }


}
