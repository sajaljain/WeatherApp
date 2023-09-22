package com.sajal.weatherapp.home.repository

import com.sajal.weatherapp.base.BaseRepo
import com.sajal.weatherapp.base.viewmodel.DataResponse
import com.sajal.weatherapp.home.model.WeatherDataModel
import com.sajal.weatherapp.network.UrlConstants
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class WeatherRepository : BaseRepo() {
    suspend fun getWeatherData(lat: String, longi: String)
            : DataResponse<WeatherDataModel> = withContext(Dispatchers.IO) {
        try {
            val response = apiClient.getWeatherFeed(
                UrlConstants.WEATHER_DATA_URL,
                lat,
                longi
            )
            if (response != null) {
                return@withContext DataResponse.Success(response)
            } else
                return@withContext DataResponse.Error("Something went wrong")
        } catch (e: Exception) {
            e.printStackTrace()
            return@withContext DataResponse.Error("Oops an exception occured")
        }
    }
}