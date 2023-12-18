package com.jyh.core.location.di

import com.jyh.core.location.datasource.LocationDataSource
import com.jyh.core.location.datasource.LocationDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface LocationModule {
    @Binds
    abstract fun provideLocationDataSource(locationDataSourceImpl: LocationDataSourceImpl): LocationDataSource
}
