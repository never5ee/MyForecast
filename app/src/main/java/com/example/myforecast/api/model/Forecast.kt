package com.example.myforecast.api.model

data class Forecast(
    val name: String,
    val main: Main,
    val wind: Wind
)