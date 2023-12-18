package com.jyh.core.network.di

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.jyh.core.common.network.AnyWeatherDispatchers
import com.jyh.core.common.network.Dispatcher
import com.jyh.core.network.datasource.weather.WeatherDataSource
import com.jyh.core.network.datasource.weather.WeatherDataSourceImpl
import com.jyh.core.network.datasource.weather.WeatherService
import com.jyh.core.network.interceptor.WeatherInterceptor
import com.jyh.core.network.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {
    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder().addInterceptor(WeatherInterceptor()).build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        val json = Json {
            ignoreUnknownKeys = true
            coerceInputValues = true
        }
        return Retrofit
            .Builder()
            .baseUrl(Constants.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(json.asConverterFactory(Constants.MEDIA_TYPE.toMediaType()))
            .build()
    }

    @Provides
    @Singleton
    fun provideWeatherService(retrofit: Retrofit): WeatherService {
        return retrofit.create(WeatherService::class.java)
    }

    @Provides
    @Singleton
    fun provideWeatherDataSource(
        @Dispatcher(AnyWeatherDispatchers.IO) dispatcher: CoroutineDispatcher,
        weatherService: WeatherService,
    ): WeatherDataSource {
        return WeatherDataSourceImpl(dispatcher, weatherService)
    }
}
