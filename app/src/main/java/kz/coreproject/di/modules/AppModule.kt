package kz.coreproject.di.modules

import dagger.Module
import kz.coreproject.di.modules.common.NetworkModule
import kz.coreproject.di.modules.common.PreferenceModule
import kz.coreproject.di.modules.common.UtilsModule
import kz.coreproject.di.view_model.base.ViewModelFactoryModule

@Module(
    includes = [
        NetworkModule::class,
        PreferenceModule::class,
        UtilsModule::class,

        //api
        ApiModule::class,

        //repository
        RepositoryModule::class,

        //
        ViewModelFactoryModule::class,
        ViewModelModule::class
    ]
)
class AppModule {
}