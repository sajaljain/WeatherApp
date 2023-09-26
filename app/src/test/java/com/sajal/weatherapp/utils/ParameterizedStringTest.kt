package com.sajal.weatherapp.utils

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class ParameterizedStringTest(val input: String, val expectedOut: String) {

    @Test
    fun isValidStringReverseTest() {
        //Arrange

        val helper = Helper()
        //act

        val res = helper.isValidStringReverse(input)
        //asset
        Assert.assertEquals(expectedOut, res)
    }


    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun getData(): List<Array<Any>> {
            return listOf(
                arrayOf("ABC", "CBA"),
                arrayOf("Sajal", "lajaS"),
                arrayOf("a", "a"),
                arrayOf("", "")
            )
        }
    }
}