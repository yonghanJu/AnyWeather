package com.jyh.core.location.datasource

import com.jyh.core.location.model.LatLon

interface LocationDataSource {
    suspend fun getLocation(): LatLon
}
