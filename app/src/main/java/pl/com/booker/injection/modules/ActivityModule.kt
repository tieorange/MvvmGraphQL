package pl.com.booker.ui.base.modules

import android.content.Context
import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity
import pl.com.booker.ui.base.qualifier.ActivityContext
import pl.com.booker.ui.base.qualifier.ActivityFragmentManager
import pl.com.booker.injection.scopes.PerActivity
import com.momedia.cargo.ui.base.navigator.ActivityNavigator
import com.momedia.cargo.ui.base.navigator.Navigator
import com.momedia.cargo.util.ErrorHandler
import dagger.Module
import dagger.Provides


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


    @Provides
    @PerActivity
    internal fun providesErrorHandlerCargo(
            @ActivityContext context: Context,
            navigator: Navigator
    ): ErrorHandler {
        return ErrorHandler(context, navigator)
    }
}
