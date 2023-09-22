package com.sajal.weatherapp.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object ApiClient {

    private val instance: ApiInterface by lazy {
        create()
    }

    fun getClient(): ApiInterface = instance

    private fun create(): ApiInterface {
        val builder = OkHttpClient().newBuilder()
        val okHttpClient: OkHttpClient = builder
            .connectTimeout(10, TimeUnit.SECONDS)
            .readTimeout(10, TimeUnit.SECONDS)
            .writeTimeout(10, TimeUnit.SECONDS)
            .build()

        val retrofit = Retrofit.Builder()
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(UrlConstants.BASE_API_URL)
            .build()

        return retrofit.create(ApiInterface::class.java)
    }


}
