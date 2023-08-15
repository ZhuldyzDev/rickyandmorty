package kz.test.rickandmorty.di.contributes_android_injector.activity

import dagger.Module
import dagger.android.ContributesAndroidInjector

import kz.test.rickandmorty.di.contributes_android_injector.fragment.CharacterFragmentsBuildersModule
import kz.test.rickandmorty.di.contributes_android_injector.fragment.SplashFragmentsBuildersModule
import kz.test.rickandmorty.ui.activities.main.MainActivity
import kz.test.rickandmorty.ui.activities.splash.SplashActivity

@Module
abstract class ActivityBuildersModule {

    @ContributesAndroidInjector(
        modules = [
            SplashFragmentsBuildersModule::class
        ]
    )
    internal abstract fun splashActivity(): SplashActivity

    @ContributesAndroidInjector(
        modules = [
            CharacterFragmentsBuildersModule::class
        ]
    )
    internal abstract fun mainActivity(): MainActivity

}