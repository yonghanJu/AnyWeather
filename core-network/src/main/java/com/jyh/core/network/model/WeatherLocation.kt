package com.jyh.core.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WeatherLocation(
    @SerialName("country") val country: String,
    @SerialName("region") val region: String,
    @SerialName("name") val name: String,
    @SerialName("localtime") val localtime: String,
    @SerialName("lat") val lat: Double,
    @SerialName("lon") val lon: Double,
)
