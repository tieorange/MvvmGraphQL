package com.momedia.cargo.util.payu

import android.content.Context
import com.momedia.cargo.MyApp
import com.payu.android.sdk.payment.model.MerchantOAuthAccessToken
import com.payu.android.sdk.payment.service.TokenProviderService
import com.payu.android.sdk.payment.service.exception.ExternalRequestError
import com.payu.android.sdk.payment.service.exception.ExternalRequestError.ExternalErrorType.NETWORK_ERROR

class PayUTokenProviderService(context: Context) : TokenProviderService(context) {

    override fun provideAccessToken(): MerchantOAuthAccessToken {
        val accessToken: String
        try {
            val tokenWithBearer = MyApp.appComponent.loginManager().getTokenWithBearer()
            accessToken = MyApp.appComponent.myApi().getPayUToken(tokenWithBearer).blockingGet().accessToken
        } catch (e: Exception) {
            throw ExternalRequestError(NETWORK_ERROR)
        }
        return MerchantOAuthAccessToken(accessToken)
    }
}