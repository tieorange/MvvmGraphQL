package pl.com.booker.injection.components

import android.content.Context
import android.content.res.Resources
import dagger.Component
import pl.com.booker.data.remote.MyApi
import pl.com.booker.ui.base.modules.AppModule
import pl.com.booker.ui.base.modules.DataModule
import pl.com.booker.injection.modules.NetModule
import pl.com.booker.ui.base.qualifier.AppContext
import pl.com.booker.ui.base.scopes.PerApplication


@PerApplication
@Component(modules = arrayOf(AppModule::class, NetModule::class, DataModule::class))
interface AppComponent {
    @AppContext fun appContext(): Context
    fun resources(): Resources

    fun myApi(): MyApi
    fun loginManager(): LoginManager
}

