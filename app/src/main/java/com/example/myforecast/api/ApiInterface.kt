package com.example.myforecast.api

import com.example.myforecast.api.model.Forecast
import com.example.myforecast.utils.Constants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("weather")
    suspend fun getForecastListApi(
        @Query("q") name:String,
        @Query("units") units: String = Constants.METRIC,
        @Query("appid") appid: String = Constants.APPID
    ) : Response<Forecast>

}