package kz.test.rickandmorty.di.modules

import dagger.Module
import kz.test.rickandmorty.di.view_model.CharacterViewModelModule
import kz.test.rickandmorty.di.view_model.SplashViewModelModule

@Module(
    includes = [
        SplashViewModelModule::class,
        CharacterViewModelModule::class
    ]
)
class ViewModelModule {
}