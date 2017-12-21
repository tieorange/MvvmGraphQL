package pl.com.booker.util

import android.content.Context
import pl.com.booker.data.remote.MyApi

class FirebaseTokenHelper(
        private val context: Context,
        private val loginManager: LoginManager,
        private val myApi: MyApi
) {
    /*fun sendToServerAndReturnDisposable(): Disposable? {
        val firebaseToken = FirebaseInstanceId.getInstance().token

        if (firebaseToken != null) {
            return myApi.updateDeviceToken(loginManager.getTokenWithBearer(), firebaseToken)
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(
                            {
                                context.logd { "Device firebaseToken is saved $firebaseToken" }
                            },
                            { throwable: Throwable ->
                                context.loge { "DEVICE TOKEN ISN'T SAVED ${throwable.message}" }
                            }
                    )
        }
        return null
    }*/
}