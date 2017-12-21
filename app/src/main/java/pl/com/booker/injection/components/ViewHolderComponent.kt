package pl.com.booker.ui.base.components

import pl.com.booker.ui.base.modules.ViewHolderModule
import pl.com.booker.ui.base.modules.ViewModelModule
import pl.com.booker.ui.base.scopes.PerViewHolder

import dagger.Component


@PerViewHolder
@Component(dependencies = arrayOf(ActivityComponent::class), modules = arrayOf(ViewHolderModule::class, ViewModelModule::class))
interface ViewHolderComponent {

}
