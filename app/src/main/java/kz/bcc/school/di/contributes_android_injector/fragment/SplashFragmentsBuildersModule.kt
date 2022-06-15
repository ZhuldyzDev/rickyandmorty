package kz.bcc.school.di.contributes_android_injector.fragment

import dagger.Module
import dagger.android.ContributesAndroidInjector
import kz.bcc.school.ui.splash.SplashFragment

@Module
abstract class SplashFragmentsBuildersModule {

    @ContributesAndroidInjector
    internal abstract fun splashFragment(): SplashFragment

}