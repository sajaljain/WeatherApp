package com.sajal.weatherapp.search.model
import com.google.gson.annotations.SerializedName

class SearchModel : ArrayList<SearchModelItem>()

data class SearchModelItem(
    @SerializedName("country")
    val country: String?,
    @SerializedName("lat")
    val lat: Double?,
    @SerializedName("lon")
    val lon: Double?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("state")
    val state: String?
)