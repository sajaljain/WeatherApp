package com.sajal.weatherapp.network

import com.sajal.weatherapp.home.model.WeatherDataModel
import com.sajal.weatherapp.search.model.SearchModel
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

interface ApiInterface {

    @GET
    suspend fun getWeatherFeed(
        @Url url: String?,
        @Query("lat") lati: String?,
        @Query("lon") longi: String?,
        @Query("units") units: String? = "metric",
        @Query("appid") apiKey: String = UrlConstants.API_KEY): WeatherDataModel?


    @GET
    suspend fun getLatLongByName(
        @Url url: String?,
        @Query("q") q: String?,
        @Query("limit") limit: Int,
        @Query("appid") apiKey: String =  UrlConstants.API_KEY): SearchModel?


}