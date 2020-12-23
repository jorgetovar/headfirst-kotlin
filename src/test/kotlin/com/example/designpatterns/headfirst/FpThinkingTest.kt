package com.example.designpatterns.headfirst

import com.example.designpatterns.headfirst.fp.PerfectNumbersFinder
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.CoreMatchers.`is`
import org.junit.jupiter.api.Test

class FpThinkingTest {

    private val perfectNumbers = listOf(6, 28, 496, 8128, 33550336)

    @Test
    fun perfectNumbersAllValid() {
        perfectNumbers.forEach {

            assertThat(PerfectNumbersFinder.factors(it), `is`(true))
        }
    }

    @Test
    fun sixPerfectNumber() {
        assertThat(PerfectNumbersFinder.factors(6), `is`(true))
    }

    @Test
    fun bigPerfectNumber() {
        assertThat(PerfectNumbersFinder.factors(33550336), `is`(true))
    }

    @Test
    fun perfectNumbersTo100_000() {

        for (i in 2..100000) if (perfectNumbers.contains(i)) assertThat(PerfectNumbersFinder.factors(i), `is`(true))
        else assertThat(PerfectNumbersFinder.factors(i), `is`(false))
    }


}
