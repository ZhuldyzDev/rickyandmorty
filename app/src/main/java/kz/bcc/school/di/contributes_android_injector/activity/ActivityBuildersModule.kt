package kz.bcc.school.di.contributes_android_injector.activity

import dagger.Module
import dagger.android.ContributesAndroidInjector
import kz.bcc.school.di.contributes_android_injector.fragment.AboutFragmentsBuildersModule
import kz.bcc.school.di.contributes_android_injector.fragment.SplashFragmentsBuildersModule
import kz.bcc.school.ui.activities.main.MainActivity
import kz.bcc.school.ui.activities.splash.SplashActivity

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
            AboutFragmentsBuildersModule::class
        ]
    )
    internal abstract fun mainActivity(): MainActivity

}