package com.sajal.weatherapp.utils

import android.text.TextUtils

class Helper {
    fun isPalindrome(value: String): Boolean {
        var startIndex = 0
        var endIndex = value.length - 1
        while (startIndex < endIndex) {
            if (!value.get(startIndex).equals(value.get(endIndex))) {
                return false
            }
            startIndex++
            endIndex--
        }
        return true
    }

    fun isValidPassword(password: String?): Boolean {
        if (password != null && !password.isBlank() && password.length in 6..15) {
            return true
        }
        return false
    }

    fun isValidStringReverse(s: String?): String {
        if (s == null) throw IllegalArgumentException("Required an String")
        lateinit var rev: StringBuilder
        val strLength = s.length
        var index = strLength - 1
        rev = StringBuilder()
        while (index >= 0) {
            rev = rev.append(s.get(index))
            index--
        }
        return rev.toString()
    }

}