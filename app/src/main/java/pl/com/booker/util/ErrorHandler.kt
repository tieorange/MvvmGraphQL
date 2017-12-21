package pl.com.booker.util

import android.content.Context
import com.mcxiaoke.koi.ext.toast
import pl.com.booker.R
import pl.com.booker.injection.scopes.PerActivity
import pl.com.booker.ui.base.navigator.Navigator
import retrofit2.HttpException
import java.net.UnknownHostException
import javax.inject.Inject

@PerActivity
class ErrorHandler
@Inject
constructor(
        internal val context: Context,
        private val navigator: Navigator
) : ErrorHandlerInterface {

    override fun handleError(throwable: Throwable) {
        when (throwable) {
            is HttpException -> when (throwable.code()) {
                UNAUTHORIZED -> {
                    unauthorizedRequest()
                }
                VALIDATION_FAILED -> {
                    validationFailed()
                }
                NOT_FOUND -> {
                    notFound()
                }
                else -> {
                    noInternet()
                }
            }
            is UnknownHostException -> notConnectedToInternet()
            else -> noInternet()
        }
    }

    private fun notConnectedToInternet() {
        context.toast(R.string.no_internet)
    }

    private fun notFound() {
        context.toast(R.string.not_found)
    }

    override fun validationFailed() {
        context.toast(R.string.validation_failed)
    }

    override fun unauthorizedRequest() {
        navigator.logout()
    }

    override fun noInternet() {
        context.toast(R.string.server_not_responding)
    }

    companion object {
        const val NOT_FOUND = 404
        const val UNAUTHORIZED = 401
        const val VALIDATION_FAILED = 400
    }
}