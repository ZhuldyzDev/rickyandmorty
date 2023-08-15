package kz.test.rickandmorty.di.contributes_android_injector.fragment

import dagger.Module
import dagger.android.ContributesAndroidInjector
import kz.test.rickandmorty.ui.character.CharactersFragment
import kz.test.rickandmorty.ui.detail.CharacterDetailFragment

@Module
abstract class CharacterFragmentsBuildersModule {

    @ContributesAndroidInjector
    internal abstract fun characterFragment(): CharactersFragment

    @ContributesAndroidInjector
    internal abstract fun characterDetailFragment(): CharacterDetailFragment

}