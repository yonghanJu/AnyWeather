package com.jyh.core.data.repository

import com.jyh.core.data.mapper.toWeatherInfo
import com.jyh.core.location.datasource.LocationDataSource
import com.jyh.core.model.WeatherInfo
import com.jyh.core.network.datasource.weather.WeatherDataSource
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val weatherDataSource: WeatherDataSource,
    private val locationDataSource: LocationDataSource,
) : WeatherRepository {
    override suspend fun getCurrentWeather(): WeatherInfo {
        val latLon = locationDataSource.getLocation()
        return weatherDataSource.getCurrentWeather(latLon.lat, latLon.lon).toWeatherInfo()
    }
}
