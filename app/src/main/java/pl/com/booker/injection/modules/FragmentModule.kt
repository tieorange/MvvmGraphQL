package pl.com.booker.ui.base.modules

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import pl.com.booker.ui.base.qualifier.ChildFragmentManager
import pl.com.booker.ui.base.scopes.PerFragment
import com.momedia.cargo.ui.base.navigator.ActivityNavigator
import com.momedia.cargo.ui.base.navigator.ChildFragmentNavigator
import com.momedia.cargo.ui.base.navigator.FragmentNavigator
import com.momedia.cargo.util.ErrorHandler
import dagger.Module
import dagger.Provides


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
