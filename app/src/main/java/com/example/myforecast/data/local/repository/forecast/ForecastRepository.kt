package com.example.myforecast.data.local.repository.forecast

import com.example.myforecast.api.Result
import com.example.myforecast.api.successed
import com.example.myforecast.data.local.database.ForecastEntity
import com.example.myforecast.utils.Constants
import javax.inject.Inject


class ForecastRepository @Inject constructor(
    private val forecastLocalDataSource: ForecastLocalDataSource,
    private val forecastRemoteDataSource: ForecastRemoteDataSource
) {

    fun forecastByName(name:String) = forecastLocalDataSource.forecastByName(name)

    suspend fun getForecastByName(name:String){
        when(val result = forecastRemoteDataSource.getForecastByName(name)) {

            is Result.Success ->{
                if (result.successed){
                    val customForecast = result.data.let { item ->
                        ForecastEntity(
                            item.name,
                            item.main,
                            item.wind
                        )
                    }//let
                    forecastLocalDataSource.insertForecastIntoDatabase(customForecast)

                } else{
                    Result.Error(Constants.GENERIC_ERROR)
                }
            } // Result.Success
            else -> result as Result.Error
        } //when
    } // getForecastByName

}