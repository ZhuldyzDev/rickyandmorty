package kz.bcc.school.di.modules

import dagger.Module
import kz.bcc.school.di.view_model.CharacterViewModelModule
import kz.bcc.school.di.view_model.ActivityViewModelModule
import kz.bcc.school.di.view_model.SplashViewModelModule

@Module(
    includes = [
        ActivityViewModelModule::class,
        SplashViewModelModule::class,
        CharacterViewModelModule::class
    ]
)
class ViewModelModule {
}