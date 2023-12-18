package com.jyh.core.network.datasource.weather

import com.jyh.core.network.model.WeatherResponse

interface WeatherDataSource {
    suspend fun getCurrentWeather(lat: Double, lon: Double): WeatherResponse
}
