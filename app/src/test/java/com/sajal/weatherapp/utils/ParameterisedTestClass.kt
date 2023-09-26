package com.sajal.weatherapp.utils

import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(value = Parameterized::class)
class ParameterisedTestClass(val input: String, val expectedValue: Boolean) {

    @Test
    fun test() {
        val helper = Helper()
        val res = helper.isPalindrome(input)
        assertEquals(expectedValue, res)
    }

    companion object {
        @JvmStatic
        @Parameterized.Parameters(name = "{index} {0} is a palindrome {1}")
        fun setData(): List<Array<Any>> {
            return listOf(
                arrayOf("hello", false),
                arrayOf("level", true),
                arrayOf("a", true),
                arrayOf("", true)
            )
        }
    }


}