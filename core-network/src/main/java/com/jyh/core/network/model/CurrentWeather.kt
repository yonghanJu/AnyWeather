package com.jyh.core.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CurrentWeather(
    @SerialName("air_quality") val airQuality: AirQuality,
    @SerialName("cloud") val cloud: Int,
    @SerialName("condition") val condition: WeatherCondition,
    @SerialName("feelslike_c") val feelslikeC: Double,
    @SerialName("humidity") val humidity: Int,
    @SerialName("is_day") val isDay: Int,
    @SerialName("last_updated") val lastUpdated: String,
    @SerialName("precip_mm") val precipMm: Double,
    @SerialName("pressure_mb") val pressureMb: Double,
    @SerialName("temp_c") val tempC: Double,
    @SerialName("uv") val uv: Double,
    @SerialName("vis_km") val visKm: Double,
    @SerialName("wind_dir") val windDir: String,
    @SerialName("wind_kph") val windKph: Double,
)
