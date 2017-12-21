package pl.com.booker.ui.base.modules

import com.momedia.cargo.data.local.MyRepo
import com.momedia.cargo.data.local.MyRepoImpl
import dagger.Binds
import dagger.Module


@Module
abstract class DataModule {

    @Binds
    internal abstract fun bindMyrepo(repo: MyRepoImpl): MyRepo

}
