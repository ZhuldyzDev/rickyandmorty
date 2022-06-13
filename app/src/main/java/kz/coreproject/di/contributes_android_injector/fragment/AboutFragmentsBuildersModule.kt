package kz.coreproject.di.contributes_android_injector.fragment

import dagger.Module
import dagger.android.ContributesAndroidInjector
import kz.coreproject.ui.about.AboutFragment

@Module
abstract class AboutFragmentsBuildersModule {

    @ContributesAndroidInjector
    internal abstract fun aboutFragment(): AboutFragment

}