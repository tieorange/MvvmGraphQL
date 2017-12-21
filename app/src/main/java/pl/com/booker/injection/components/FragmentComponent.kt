package pl.com.booker.injection.components

import dagger.Component
import pl.com.booker.injection.modules.FragmentModule
import pl.com.booker.injection.modules.ViewModelModule
import pl.com.booker.injection.scopes.PerFragment


@PerFragment
@Component(dependencies = arrayOf(ActivityComponent::class),
           modules = arrayOf(FragmentModule::class, ViewModelModule::class))
interface FragmentComponent {

//    fun inject(myDataFragment: MyDataFragment)
}
