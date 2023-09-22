package com.sajal.weatherapp.search.repository

import com.sajal.weatherapp.base.BaseRepo
import com.sajal.weatherapp.base.viewmodel.DataResponse
import com.sajal.weatherapp.network.UrlConstants
import com.sajal.weatherapp.search.model.SearchModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class SearchRepository : BaseRepo() {
    suspend fun getSearchResult(query: String?): DataResponse<SearchModel> =
        withContext(Dispatchers.IO) {
            try {
                val response = apiClient.getLatLongByName(
                    UrlConstants.GEOCODING_URL,
                    query,
                    UrlConstants.API_RES_LIMIT
                )
                if (response != null) {
                    return@withContext DataResponse.Success(response)
                } else
                    return@withContext DataResponse.Error("No Data Found")
            } catch (e: Exception) {
                e.printStackTrace()
            }
            return@withContext DataResponse.Error("Oops an exception occurred")
        }
}