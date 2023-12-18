package com.jyh.core.network.datasource.weather

import com.jyh.core.model.WeatherInfo

interface WeatherDataSource {
    suspend fun getCurrentWeather(lat: Double, lon: Double): WeatherInfo
}
