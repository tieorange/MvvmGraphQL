package pl.com.booker.injection.components

import android.content.Context
import android.support.v4.app.FragmentManager
import dagger.Component
import pl.com.booker.ui.main.MainActivity
import pl.com.booker.injection.modules.ViewModelModule
import pl.com.booker.injection.scopes.PerActivity
import pl.com.booker.injection.modules.ActivityModule
import pl.com.booker.ui.base.navigator.Navigator
import pl.com.booker.injection.qualifier.ActivityContext
import pl.com.booker.injection.qualifier.ActivityFragmentManager


@PerActivity
@Component(dependencies = arrayOf(AppComponent::class),
           modules = arrayOf(ActivityModule::class, ViewModelModule::class))
interface ActivityComponent : AppComponent {

    @ActivityContext fun activityContext(): Context
    @ActivityFragmentManager fun defaultFragmentManager(): FragmentManager
    fun navigator(): Navigator
//    fun errorHandlerCargo(): ErrorHandler

    fun inject(activity: MainActivity)
}
