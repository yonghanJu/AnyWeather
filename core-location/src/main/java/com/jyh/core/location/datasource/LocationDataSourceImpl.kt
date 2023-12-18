package com.jyh.core.location.datasource

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat
import com.google.android.gms.location.LocationServices
import com.jyh.core.common.network.AnyWeatherDispatchers
import com.jyh.core.common.network.Dispatcher
import com.jyh.core.location.model.LatLon
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlinx.coroutines.withContext
import javax.inject.Inject
import kotlin.coroutines.resume

class LocationDataSourceImpl @Inject constructor(
    @Dispatcher(AnyWeatherDispatchers.IO) private val dispatcher: CoroutineDispatcher,
    @ApplicationContext private val context: Context,
) : LocationDataSource {

    private val fusedLocationProviderClient by lazy {
        LocationServices.getFusedLocationProviderClient(
            context,
        )
    }

    override suspend fun getLocation(): LatLon = withContext(dispatcher) {
        if (ActivityCompat.checkSelfPermission(
                context,
                Manifest.permission.ACCESS_COARSE_LOCATION,
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            throw Exception("위치 권한이 허락되지 않음.")
        }

        suspendCancellableCoroutine<LatLon> { continuation ->
            fusedLocationProviderClient.lastLocation
                .addOnSuccessListener { location ->
                    continuation.resume(LatLon(location.latitude, location.longitude))
                }
        }
    }
}
