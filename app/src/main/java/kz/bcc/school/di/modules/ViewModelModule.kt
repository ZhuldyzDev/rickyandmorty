package kz.bcc.school.di.modules

import dagger.Module
import kz.bcc.school.di.view_model.AboutViewModelModule
import kz.bcc.school.di.view_model.ActivityViewModelModule
import kz.bcc.school.di.view_model.SplashViewModelModule

@Module(
    includes = [
        ActivityViewModelModule::class,
        SplashViewModelModule::class,
        AboutViewModelModule::class
    ]
)
class ViewModelModule {
}