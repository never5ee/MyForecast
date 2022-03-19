package com.example.myforecast.data.local.database

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.myforecast.api.model.Main
import com.example.myforecast.api.model.Wind

@Entity(tableName = "forecast_list")
data class ForecastEntity(
    @PrimaryKey
    val name: String?,
    @Embedded
    val main: Main?,
    @Embedded
    val wind: Wind?
)
