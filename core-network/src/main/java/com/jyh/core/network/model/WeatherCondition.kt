package com.jyh.core.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WeatherCondition(
    @SerialName("code") val code: Int,
    @SerialName("icon") val iconUrl: String,
    @SerialName("text") val description: String,
)
