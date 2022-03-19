package com.example.myforecast.data.local.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ForecastDao {

    //Получение определенного прогноза по name
    @Query("SELECT * FROM forecast_list WHERE name = :name")
    fun forecastLiveDataFromName(name: String): ForecastEntity

    //Обновить данные
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(list: ForecastEntity)

}