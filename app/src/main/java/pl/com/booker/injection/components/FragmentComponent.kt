package pl.com.booker.ui.base.components

import pl.com.booker.injection.components.ActivityComponent
import pl.com.booker.injection.modules.ViewModelModule
import pl.com.booker.ui.base.modules.FragmentModule
import pl.com.booker.ui.base.scopes.PerFragment


@PerFragment
@Component(dependencies = arrayOf(ActivityComponent::class),
           modules = arrayOf(FragmentModule::class, ViewModelModule::class))
interface FragmentComponent {

//    fun inject(myDataFragment: MyDataFragment)
}
