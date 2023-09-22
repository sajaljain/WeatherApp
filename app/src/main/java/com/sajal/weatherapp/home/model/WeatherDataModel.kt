package com.sajal.weatherapp.home.model

import com.google.gson.annotations.SerializedName

data class WeatherDataModel(
    @SerializedName("weather") var weather: ArrayList<Weather> = arrayListOf(),
    @SerializedName("main") var main: Main?,
    @SerializedName("name") var name: String? = null,
    @SerializedName("dt") var dt: Int? = null,
    @SerializedName("wind") var wind: Wind? = null,
    @SerializedName("sys") var sys: Sys? = null
)

data class Main(
    @SerializedName("temp") var temp: Double? = null,
    @SerializedName("temp_min") var tempMin: Double? = null,
    @SerializedName("temp_max") var tempMax: Double? = null,
    @SerializedName("humidity") var humidity: Int? = null
)

data class Weather(
    @SerializedName("id") var id: Int? = null,
    @SerializedName("main") var main: String? = null,
    @SerializedName("description") var description: String? = null,
    @SerializedName("icon") var icon: String? = null
)

data class Wind(
    @SerializedName("speed") var speed: Double? = null
)

data class Sys(
    @SerializedName("sunrise") var sunrise: Int? = null,
    @SerializedName("sunset") var sunset: Int? = null
)


