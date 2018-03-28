package pl.com.booker.injection.components

import android.content.Context
import android.content.res.Resources
import dagger.Component
import pl.com.booker.injection.modules.AppModule
import pl.com.booker.injection.modules.DataModule
import pl.com.booker.injection.qualifier.AppContext
import pl.com.booker.injection.scopes.PerApplication
import pl.com.booker.util.LoginManager
import pl.com.graphqldemo.data.GraphQlClient
import pl.com.graphqldemo.injection.modules.NetModule


@PerApplication
@Component(modules = arrayOf(AppModule::class, NetModule::class, DataModule::class))
interface AppComponent {
    @AppContext fun appContext(): Context
    fun resources(): Resources
    fun loginManager(): LoginManager
    fun graphQl(): GraphQlClient
}

