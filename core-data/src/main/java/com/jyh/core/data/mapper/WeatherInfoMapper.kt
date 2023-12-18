package com.jyh.core.data.mapper

import com.jyh.core.model.WeatherInfo
import com.jyh.core.network.model.WeatherResponse

fun WeatherResponse.toWeatherInfo(): WeatherInfo = WeatherInfo(
    co = current.airQuality.co,
    no2 = current.airQuality.no2,
    o3 = current.airQuality.o3,
    so2 = current.airQuality.so2,
    airQualityIndex = current.airQuality.usEpaIndex,
    conditionCode = current.condition.code,
    conditionIconUrl = current.condition.iconUrl,
    conditionDescription = current.condition.description,
    cloud = current.cloud,
    feelsLikeC = current.feelsLikeC,
    humidity = current.humidity,
    isDay = current.isDay,
    lastUpdated = current.lastUpdated,
    precipMm = current.precipMm,
    pressureMb = current.pressureMb,
    tempC = current.tempC,
    uv = current.uv,
    visKm = current.visKm,
    windDir = current.windDir,
    windKph = current.windKph,
    region = location.country +
        (if (location.region.isNotEmpty()) " ${location.region} " else " ") +
        location.name,
    localtime = location.localtime,
)
