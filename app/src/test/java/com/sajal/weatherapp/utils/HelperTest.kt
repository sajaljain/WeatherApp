package com.sajal.weatherapp.utils

import com.vmadalin.easypermissions.BuildConfig
import org.junit.Assert.assertEquals
import org.junit.Test


class HelperTest {
    @Test
    fun isPalindromeIP(){
        //Arrange
        val helper = Helper()

        //Act
        val result = helper.isPalindrome("")


        //Assert
        assertEquals(true,result)
    }

    @Test
    fun isPalindromeInput_Level_Output_TRUE() {
        //Arrange
        val helper = Helper()

        //Act
        val result = helper.isPalindrome("a")


        //Assert

        assertEquals(true,result)
    }

    @Test
    fun isValidPasswordTest() {
        //Arrange

        val helper = Helper()
        //act

        val res = helper.isValidPassword("")
        //asset
        assertEquals(false,res)
    }
}