package pl.com.booker.util

interface ErrorHandlerInterface {
    fun handleError(throwable: Throwable)
    fun unauthorizedRequest()
    fun noInternet()
    fun validationFailed()
}