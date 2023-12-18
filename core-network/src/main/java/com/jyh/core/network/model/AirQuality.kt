package com.jyh.core.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AirQuality(
    @SerialName("co") val co: Double,
    @SerialName("no2") val no2: Double,
    @SerialName("o3") val o3: Double,
    @SerialName("so2") val so2: Double,
    @SerialName("us-epa-index") val usEpaIndex: Int,
)
