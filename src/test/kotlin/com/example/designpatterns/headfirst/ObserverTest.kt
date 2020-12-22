package com.example.designpatterns.headfirst

import org.hamcrest.CoreMatchers
import org.hamcrest.CoreMatchers.nullValue
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.CoreMatchers.`is`
import org.junit.jupiter.api.Test

class ObserverTest {

    @Test
    fun subject() {
        assertThat(null, `is`(nullValue()))
    }

}
