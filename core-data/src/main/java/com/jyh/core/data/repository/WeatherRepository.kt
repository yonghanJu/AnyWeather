package com.jyh.core.data.repository

import com.jyh.core.model.WeatherInfo

interface WeatherRepository {
    suspend fun getCurrentWeather(): WeatherInfo
}
