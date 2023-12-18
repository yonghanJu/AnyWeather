package com.jyh.core.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WeatherResponse(
    @SerialName("current") val current: CurrentWeather,
    @SerialName("location") val location: WeatherLocation,
)
