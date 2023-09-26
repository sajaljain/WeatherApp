package com.sajal.weatherapp.utils

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class ParameterizedPasswordTest(val input:String?,val expectedOut : Boolean) {

    @Test
    fun isValidPasswordTest() {
        //Arrange

        val helper = Helper()
        //act

        val res = helper.isValidPassword(input)
        //asset
        Assert.assertEquals(expectedOut, res)
    }



    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun getData() : List<Array<Any>> {
            return listOf(
                arrayOf("      ",false),
                arrayOf("qwerty@1234",true),
                arrayOf("times@1234",true)
            )
        }
    }
}