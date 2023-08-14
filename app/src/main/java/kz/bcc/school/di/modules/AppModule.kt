package kz.bcc.school.di.modules

import dagger.Module
import kz.bcc.school.di.modules.common.NetworkModule
import kz.bcc.school.di.view_model.base.ViewModelFactoryModule

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