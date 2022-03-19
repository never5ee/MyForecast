package com.example.myforecast.data.local.repository.forecast

import com.example.myforecast.api.ApiInterface
import com.example.myforecast.api.BaseRemoteDataSource
import com.example.myforecast.api.Result
import com.example.myforecast.api.model.Forecast
import com.example.myforecast.utils.Constants
import javax.inject.Inject


class ForecastRemoteDataSource @Inject constructor(private val service: ApiInterface): BaseRemoteDataSource(){

    suspend fun getForecastByName(name:String, appid: String = Constants.APPID, units: String = Constants.METRIC): Result<Forecast> =
        getResult {
            service.getForecastApi(name, appid, units)
        }
}
