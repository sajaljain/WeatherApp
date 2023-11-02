package com.sajal.weatherapp.search.repository

import android.util.Log
import com.sajal.weatherapp.base.BaseRepo
import com.sajal.weatherapp.base.viewmodel.DataResponse
import com.sajal.weatherapp.network.UrlConstants
import com.sajal.weatherapp.search.model.SearchModel

class SearchRepository : BaseRepo() {
    suspend fun getSearchResult(query: String?): DataResponse<SearchModel>
        {
            try {
                val response = apiClient.getLatLongByName(
                    UrlConstants.GEOCODING_URL,
                    query,
                    UrlConstants.API_RES_LIMIT
                )
                if (response != null) {
                    Log.d("searchmodel", "from search repository :${Thread.currentThread().name} ")
                    return DataResponse.Success(response)
                } else
                    return DataResponse.Error("No Data Found")
            } catch (e: Exception) {
                e.printStackTrace()
            }
            return DataResponse.Error("Oops an exception occurred")
        }
}