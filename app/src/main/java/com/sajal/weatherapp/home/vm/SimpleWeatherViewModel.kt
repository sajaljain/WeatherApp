package com.sajal.weatherapp.home.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.sajal.weatherapp.base.viewmodel.BaseVM
import com.sajal.weatherapp.base.viewmodel.DataResponse
import com.sajal.weatherapp.home.model.WeatherDataModel
import com.sajal.weatherapp.home.repository.WeatherRepository
import kotlinx.coroutines.launch

class SimpleWeatherViewModel : BaseVM() {
    private val _weatherDataModel = MutableLiveData<DataResponse<WeatherDataModel>>()
    val weatherDataModel: LiveData<DataResponse<WeatherDataModel>> = _weatherDataModel
    private val weatherRepository = WeatherRepository()

    fun getData(lat: String, longi: String) {
        viewModelScope.launch {
            val data = weatherRepository.getWeatherData(lat, longi)
            _weatherDataModel.postValue(data)
        }
    }

}