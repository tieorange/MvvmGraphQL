package pl.com.booker.injection.modules

import android.content.Context
import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity
import dagger.Module
import dagger.Provides
import pl.com.booker.injection.scopes.PerActivity
import pl.com.booker.ui.base.navigator.ActivityNavigator
import pl.com.booker.ui.base.navigator.Navigator
import pl.com.booker.injection.qualifier.ActivityContext
import pl.com.booker.injection.qualifier.ActivityFragmentManager


@Module
class ActivityModule(private val activity: AppCompatActivity) {

    @Provides
    @PerActivity
    @ActivityContext
    internal fun provideActivityContext(): Context {
        return activity
    }

    @Provides
    @PerActivity
    @ActivityFragmentManager
    internal fun provideFragmentManager(): FragmentManager {
        return activity.supportFragmentManager
    }

    @Provides
    @PerActivity
    internal fun provideNavigator(): Navigator {
        return ActivityNavigator(activity)
    }
}
