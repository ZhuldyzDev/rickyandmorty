package kz.bcc.school.di.contributes_android_injector.fragment

import dagger.Module
import dagger.android.ContributesAndroidInjector
import kz.bcc.school.ui.character.CharactersFragment
import kz.bcc.school.ui.detail.CharacterDetailFragment

@Module
abstract class CharacterFragmentsBuildersModule {

    @ContributesAndroidInjector
    internal abstract fun characterFragment(): CharactersFragment

    @ContributesAndroidInjector
    internal abstract fun characterDetailFragment(): CharacterDetailFragment

}