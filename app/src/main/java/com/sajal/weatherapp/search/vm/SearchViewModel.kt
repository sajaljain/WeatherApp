package com.sajal.weatherapp.search.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sajal.weatherapp.base.viewmodel.DataResponse
import com.sajal.weatherapp.search.model.SearchModel
import com.sajal.weatherapp.search.repository.SearchRepository
import kotlinx.coroutines.launch

class SearchViewModel : ViewModel() {
    private val searchRepo = SearchRepository()
    private val _searchResult = MutableLiveData<DataResponse<SearchModel>>()
    val searchResult: LiveData<DataResponse<SearchModel>> = _searchResult


    fun getSearchQueryResult(q: String?) {
        viewModelScope.launch {
            val res = searchRepo.getSearchResult(q)
            return@launch _searchResult.postValue(res)
        }
    }

}