package kz.coreproject.di.modules

import dagger.Module
import kz.coreproject.di.view_model.AboutViewModelModule
import kz.coreproject.di.view_model.ActivityViewModelModule
import kz.coreproject.di.view_model.SplashViewModelModule

@Module(
    includes = [
        ActivityViewModelModule::class,
        SplashViewModelModule::class,
        AboutViewModelModule::class
    ]
)
class ViewModelModule {
}