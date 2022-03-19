package com.example.myforecast.data.local.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.myforecast.utils.Constants.DATABASE_NAME
import com.example.myforecast.utils.Constants.DATABASE_VERSION

@Database(entities = [ForecastEntity::class], version = DATABASE_VERSION, exportSchema = false)
abstract class ForecastDatabase: RoomDatabase() {

    abstract fun forecastDao(): ForecastDao

    companion object {
        fun buildDatabase(context:Context): ForecastDatabase {
            return Room.databaseBuilder(context, ForecastDatabase::class.java, DATABASE_NAME).build()
        }
    }

}