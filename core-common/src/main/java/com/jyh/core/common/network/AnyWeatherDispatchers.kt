package com.jyh.core.common.network

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class Dispatcher(val dispatcher: AnyWeatherDispatchers)

enum class AnyWeatherDispatchers {
    Default,
    IO,
}
