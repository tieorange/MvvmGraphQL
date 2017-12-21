package pl.com.booker.ui.base.components

import android.app.Activity
import com.crashlytics.android.Crashlytics
import com.momedia.cargo.MyApp
import com.momedia.cargo.data.model.User
import com.momedia.cargo.data.model.User.IndividualClientType
import com.momedia.cargo.data.model.User.IndividualClientType.Individual
import com.momedia.cargo.data.remote.UserToken
import pl.com.booker.ui.base.scopes.PerApplication
import com.orhanobut.hawk.Hawk
import javax.inject.Inject

@PerApplication
class LoginManager
@Inject
constructor() {
    fun saveCredentials(
            userToken: UserToken, email: String
    ) {
        Hawk.put(PREF_USER_EMAIL, email)
        Hawk.put(PREF_USER_TOKEN, userToken.token)
        Hawk.put(PREF_USER_ID, userToken.userId.toString())
        Hawk.put<IndividualClientType>(PREF_USER_TYPE, userToken.getClientType())

        Crashlytics.setUserEmail(email)
        Crashlytics.setUserIdentifier(userToken.userId.toString())
    }

    fun clearCredentials() {
        Hawk.put(PREF_USER_TOKEN, "")
    }

    private fun getToken(): String = Hawk.get(PREF_USER_TOKEN, "")

    fun getTokenWithBearer() = BEARER + getToken()

    fun getClientUserType(): User.IndividualClientType {
        return Hawk.get<IndividualClientType>(PREF_USER_TYPE, Individual)
    }

    fun isClientTypeIndividual(): Boolean {
        return getClientUserType() == User.IndividualClientType.Individual
    }

    fun isClientTypeCompany(): Boolean {
        return getClientUserType() == User.IndividualClientType.Driver
    }

    fun getCurrentOrderIdForPayU(): String? {
        return Hawk.get<String>(PREF_ORDER_ID_PAYU)
    }

    fun setCurrentOrderIdForPayU(orderId: String) {
        Hawk.put(PREF_ORDER_ID_PAYU, orderId)
    }

    fun getFirebaseDeviceToken(): String? {
        val token = Hawk.get<String>(PREF_FIREBASE_DEVICE_TOKEN)
        return if (token.isNullOrBlank()) null
        else token
    }

    fun setFirebaseDeviceToken(deviceToken: String) {
        Hawk.put(PREF_FIREBASE_DEVICE_TOKEN, deviceToken)
    }

    fun logoutUserFromAppContext(myApp: MyApp) {
        if (myApp.applicationContext is Activity) {
            myApp.applicationContext
        }
    }

    fun isUserLoggedOut(): Boolean {
        return getToken().isBlank()
    }

    companion object {
        const val PREF_USER_EMAIL = "email"
        const val PREF_USER_TOKEN = "token"
        const val PREF_USER_ID = "id"
        const val PREF_USER_TYPE = "type"
        const val PREF_ORDER_ID_PAYU = "payuOrderId"
        const val PREF_FIREBASE_DEVICE_TOKEN = "firebaseToken"

        const val BEARER = "Bearer "

    }
}