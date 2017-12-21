package com.momedia.cargo.util.payu

import android.content.Context
import com.momedia.cargo.MyApp
import com.payu.android.sdk.payment.PaymentService
import com.payu.android.sdk.payment.model.Currency.PLN
import com.payu.android.sdk.payment.model.Order.Builder

class PaymentsHelper(private val context: Context) {

    fun pay(
            amount: Long,
            orderId: String
    ) {
        saveCurrentOrderId(orderId)

        PaymentService.createInstance(context)
                .pay(
                        Builder()
                                .withAmount(amount)
                                .withCurrency(PLN)
                                .withDescription("Opłata za zamówienie CarGo: $orderId")
                                .withExtOrderId(orderId)
                                .withNotifyUrl("https://api.getcargoapp.com/payu_notify")
                                .build()
                )
    }

    private fun saveCurrentOrderId(orderId: String) {
        MyApp.appComponent.loginManager().setCurrentOrderIdForPayU(orderId)
    }
}