package pl.com.booker.injection.components

import dagger.Component
import pl.com.booker.injection.modules.ViewModelModule
import pl.com.booker.ui.base.modules.ViewHolderModule
import pl.com.booker.ui.base.scopes.PerViewHolder


@PerViewHolder
@Component(
        dependencies = arrayOf(ActivityComponent::class),
        modules = arrayOf(ViewHolderModule::class, ViewModelModule::class)
)
interface ViewHolderComponent {

}
