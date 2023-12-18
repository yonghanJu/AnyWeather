package com.jyh.core.network.datasource.weather

import com.jyh.core.network.model.WeatherResponse
import com.jyh.core.network.util.Constants.API
import com.jyh.core.network.util.Constants.QUERY
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {
    @GET(API.GET_CURRENT_WEATHER)
    suspend fun getCurrentWeather(
        @Query(QUERY.AQI_QUERY) requireAirQuality: Boolean,
        @Query(QUERY.LANG_QUERY) lang: String,
        @Query(QUERY.LOCATION_QUERY) location: String,
    ): WeatherResponse
}
