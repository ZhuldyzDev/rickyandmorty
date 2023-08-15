package kz.test.rickandmorty.di.modules.repository

import dagger.Binds
import dagger.Module
import kz.test.rickandmorty.data.repository.character.CharacterRepository
import kz.test.rickandmorty.data.repository.character.CharacterRepositoryImpl
import javax.inject.Singleton

@Module
abstract class CharacterRepositoryModule {

    @Binds
    @Singleton
    abstract fun bindCharacterRepository(impl: CharacterRepositoryImpl): CharacterRepository

}