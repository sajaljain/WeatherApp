package com.sajal.weatherapp.base

import com.sajal.weatherapp.network.ApiClient


abstract class BaseRepo {
    val apiClient by lazy { ApiClient.getClient() }
}