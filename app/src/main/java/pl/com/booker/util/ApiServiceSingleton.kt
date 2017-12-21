package pl.com.booker.util

import android.support.v4.app.FragmentActivity
import pl.com.booker.MyApp
import pl.com.booker.data.remote.MyApi
import pl.com.booker.ui.base.navigator.ActivityNavigator

class ApiServiceSingleton
private constructor(
        val token: String,
        val errorHandler: ErrorHandler,
        val myApi: MyApi
) {

    fun getContext() = errorHandler.context

    companion object {
        fun build(activity: FragmentActivity): ApiServiceSingleton {
            val errorHandler = ErrorHandler(
                    activity,
                    ActivityNavigator(activity)
            )
            val token = MyApp.appComponent.loginManager().getTokenWithBearer()

            return ApiServiceSingleton(token, errorHandler, MyApp.appComponent.myApi())
        }
    }
}