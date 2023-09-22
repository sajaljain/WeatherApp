package com.sajal.weatherapp.base.viewmodel

import androidx.lifecycle.ViewModel

abstract class BaseVM : ViewModel()

sealed class DataResponse<T>(
    val loading: Boolean = false,
    val data: T? = null,
    val error: String? = null,
    val internetAvailable: Boolean = true
) {

    class Loading<T> : DataResponse<T>(true)

    class Success<T>(data: T) : DataResponse<T>(false, data, null)

    class Error<T>(message: String?, data: T? = null) : DataResponse<T>(false, data, message)

    class NoInternet<T> : DataResponse<T>(false, null, null, false)

    override fun toString(): String {
        return "{ loading : $loading , data : $data, error : $error , internetAvailable: $internetAvailable}"
    }
}