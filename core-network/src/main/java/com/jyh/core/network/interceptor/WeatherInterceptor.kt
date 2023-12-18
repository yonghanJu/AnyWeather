package com.jyh.core.network.interceptor

import com.jyh.core.network.BuildConfig
import com.jyh.core.network.util.Constants
import okhttp3.Interceptor
import okhttp3.Response

internal class WeatherInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        var originalRequest = chain.request()
        val newUrl =
            originalRequest.url.newBuilder()
                .addQueryParameter(Constants.QUERY.API_KEY_QUERY, BuildConfig.WEATHER_API_KEY)
                .build()
        originalRequest = originalRequest.newBuilder().url(newUrl).build()
        return chain.proceed(originalRequest)
    }
}
