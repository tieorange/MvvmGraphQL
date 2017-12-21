package com.momedia.cargo.util

import android.app.Activity
import android.content.Context
import android.net.Uri
import android.support.v4.app.FragmentActivity
import android.support.v4.app.NotificationCompat.Builder
import com.google.android.gms.location.LocationRequest
import com.mcxiaoke.koi.log.logd
import com.miguelbcr.io.rx_gps_service.lib.RxGpsService
import com.miguelbcr.io.rx_gps_service.lib.RxGpsService.Listener
import com.miguelbcr.io.rx_gps_service.lib.entities.RouteStats
import com.momedia.cargo.R.mipmap
import com.momedia.cargo.R.string
import com.momedia.cargo.data.remote.location_request.LocationRequestDriver
import com.orhanobut.hawk.Hawk
import retrofit2.HttpException
import rx.Subscription
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import java.util.concurrent.TimeUnit.*

class GpsTracker(private val activity: Activity?) {
    private var LAT: Double = -1.0
    private var LNG: Double = -1.0

    var subscription: Subscription? = null

    private val GPS_INTERVAL_SECONDS = 1200

    fun initGpsTracking() {
        if (activity == null) return

        val multiplier = 500
        RxGpsService.builder(activity)
                .withDebugMode(false)
                .withSpeedMinModeAuto((5 / 3.6f) * multiplier)
                .withStageDistance((1000) * multiplier)
                .withDiscardSpeedsAbove((150 / 3.6f) * multiplier)
                .withMinDistanceTraveled(10 * multiplier)
                .withPriority(LocationRequest.PRIORITY_HIGH_ACCURACY)
                .withInterval(10000 * multiplier)
                .withFastestInterval(5000 * multiplier)
                .withDetailedWaypoints(false)
                .startService(
                        object : Listener {
                            override fun notificationServiceStarted(context: Context?): Builder {
                                return Builder(context)
                                        .setContentTitle(context?.getString(string.app_name))
                                        .setContentText("Gps tracking")
                                        .setSmallIcon(mipmap.ic_launcher)
                                        .setSound(Uri.EMPTY)
                            }

                            override fun onServiceAlreadyStarted() {
                                startListenForLocationUpdates()
                            }

                            override fun onNavigationModeChanged(isAuto: Boolean) {}
                        }
                )
    }


    private fun startListenForLocationUpdates() {
        if (!RxGpsService.isServiceStarted()) {
            initGpsTracking()
            return
        }

        unsubscribe()
        subscription = RxGpsService.instance().onRouteStatsUpdates()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .throttleFirst(5, MINUTES)
                .subscribe(
                        { routeStats ->
                            //                            logi("GPS", "last latLong ${routeStats.lastLatLong}")
                            updateLocation(routeStats)
                        },
                        { throwable ->
                            logd("GPS", "${throwable.message}")
                            initGpsTracking()
                        }
                )
    }

    private fun updateLocation(routeStats: RouteStats) {
        val latitude = routeStats.currentLocation().location().latitude
        val longitude = routeStats.currentLocation().location().longitude

        saveToLocal(latitude, longitude)

        val apiService = ApiServiceSingleton.build(activity as FragmentActivity)
        apiService.myApi.updateDriverLocation(apiService.token, LocationRequestDriver(latitude, longitude))
                .subscribeOn(io.reactivex.schedulers.Schedulers.io())
                .observeOn(io.reactivex.android.schedulers.AndroidSchedulers.mainThread())
                .subscribe(
                        { activity.logd("Location sent to server ${routeStats.currentLocation()}") },
                        {
                            if ((it as? HttpException)?.code() == ErrorHandler.UNAUTHORIZED) {
                                apiService.errorHandler.handleError(it)
                            }
                        }
                )

        LAT = latitude
        LNG = longitude
    }

    private fun saveToLocal(latitude: Double, longitude: Double) {
        if (Hawk.isBuilt()) {
            Hawk.put("lat", latitude)
            Hawk.put("lng", longitude)
        }
    }

    fun unsubscribe() {
        subscription?.unsubscribe()
        subscription = null
    }

    companion object {
        fun stopChrono() {
            if (RxGpsService.isServiceStarted()) {
                RxGpsService.instance().stopChrono()
                RxGpsService.instance().stopSelf()
            }
        }
    }
}