package com.jyh.core.network.util // ktlint-disable filename

object Constants {
    const val BASE_URL = "http://api.weatherapi.com"

    const val MEDIA_TYPE = "application/json"

    object API {
        const val GET_CURRENT_WEATHER = "/v1/current.json"
    }

    object QUERY {
        const val API_KEY_QUERY = "key"

        const val AQI_QUERY = "aqi"

        const val AQI_QUERY_VALUE = "yes"

        const val LANG_QUERY = "lang"

        const val LANG_QUERY_VALUE = "ko"

        const val LOCATION_QUERY = "q"
    }
}
