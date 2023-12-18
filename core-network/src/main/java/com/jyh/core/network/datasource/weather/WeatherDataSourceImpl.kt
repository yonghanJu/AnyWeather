package com.jyh.core.network.datasource.weather

import com.jyh.core.common.network.DawnMarketDispatchers
import com.jyh.core.common.network.Dispatcher
import com.jyh.core.model.WeatherInfo
import com.jyh.core.network.model.toWeatherInfo
import com.jyh.core.network.util.Constants
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class WeatherDataSourceImpl @Inject constructor(
    @Dispatcher(DawnMarketDispatchers.IO) private val ioDispatcher: CoroutineDispatcher,
    private val weatherService: WeatherService,
) : WeatherDataSource {
    override suspend fun getCurrentWeather(lat: Double, lon: Double): WeatherInfo =
        withContext(ioDispatcher) {
            weatherService.getCurrentWeather(
                requireAirQuality = Constants.QUERY.AQI_QUERY_VALUE,
                lang = Constants.QUERY.LANG_QUERY_VALUE,
                location = "$lat, $lon",
            ).toWeatherInfo()
        }
}
