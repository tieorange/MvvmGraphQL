package pl.com.booker

import android.content.Context
import android.content.res.Resources
import android.support.multidex.MultiDex
import android.support.multidex.MultiDexApplication
import io.reactivex.plugins.RxJavaPlugins
import pl.com.booker.injection.components.AppComponent
import pl.com.booker.injection.components.DaggerAppComponent
import pl.com.booker.injection.modules.AppModule
import pl.com.booker.injection.modules.NetModule
import timber.log.Timber

class MyApp : MultiDexApplication() {
    override fun onCreate() {
        super.onCreate()

        instance = this
        RxJavaPlugins.setErrorHandler({ Timber.e(it) })

        appComponent = DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .netModule(NetModule(this))
                .build()

        Timber.plant(Timber.DebugTree())
    }

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

    companion object {
        val BASE_URL = ""

        lateinit var instance: MyApp
            private set

        lateinit var appComponent: AppComponent
            private set

        val res: Resources
            get() = instance.resources
    }
}