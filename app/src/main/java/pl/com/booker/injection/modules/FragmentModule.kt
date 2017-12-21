package pl.com.booker.injection.modules

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import dagger.Module
import dagger.Provides
import pl.com.booker.injection.qualifier.ChildFragmentManager
import pl.com.booker.injection.scopes.PerFragment
import pl.com.booker.ui.base.navigator.ChildFragmentNavigator
import pl.com.booker.ui.base.navigator.FragmentNavigator


@Module
class FragmentModule(private val fragment: Fragment) {

    @Provides
    @PerFragment
    @ChildFragmentManager
    internal fun provideChildFragmentManager(): FragmentManager {
        return fragment.childFragmentManager
    }

    @Provides
    @PerFragment
    internal fun provideFragmentNavigator(): FragmentNavigator {
        return ChildFragmentNavigator(fragment)
    }

    /*@Provides
    @PerFragment
    internal fun providesErrorHandler(): ErrorHandler {
        return ErrorHandler(fragment.context, ActivityNavigator(fragment.activity))
    }*/
}
