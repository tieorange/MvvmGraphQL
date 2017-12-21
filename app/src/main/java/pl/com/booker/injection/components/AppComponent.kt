package pl.com.booker.ui.base.components

import android.content.Context
import android.content.res.Resources
import com.momedia.cargo.data.remote.MyApi
import pl.com.booker.ui.base.modules.AppModule
import pl.com.booker.ui.base.modules.DataModule
import pl.com.booker.ui.base.modules.NetModule
import pl.com.booker.ui.base.qualifier.AppContext
import pl.com.booker.ui.base.scopes.PerApplication
import dagger.Component
import pl.com.booker.data.remote.MyApi


@PerApplication
@Component(modules = arrayOf(AppModule::class, NetModule::class, DataModule::class))
interface AppComponent {
    @AppContext fun appContext(): Context
    fun resources(): Resources

    fun myApi(): MyApi
    fun loginManager(): LoginManager
}

