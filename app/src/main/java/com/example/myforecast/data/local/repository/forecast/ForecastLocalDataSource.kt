package com.example.myforecast.data.local.repository.forecast

import com.example.myforecast.data.local.database.ForecastDatabase
import com.example.myforecast.data.local.database.ForecastEntity
import javax.inject.Inject


class ForecastLocalDataSource @Inject constructor(private val database: ForecastDatabase) {

    //Поиск в базе данных по названию города
    fun forecastByName(name:String) = database.forecastDao().forecastFromName(name)

    //Запись в базу данных
    suspend fun insertForecastIntoDatabase(coinsToInsert: ForecastEntity) {
            database.forecastDao().insert(coinsToInsert)
    }
}