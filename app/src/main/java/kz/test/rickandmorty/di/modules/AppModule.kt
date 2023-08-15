package kz.test.rickandmorty.di.modules

import dagger.Module
import kz.test.rickandmorty.di.modules.common.NetworkModule
import kz.test.rickandmorty.di.view_model.base.ViewModelFactoryModule

@Module(
    includes = [
        NetworkModule::class,
        DatabaseModule::class,
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