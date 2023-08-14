package kz.bcc.school.di.modules.repository

import dagger.Binds
import dagger.Module
import kz.bcc.school.data.repository.character.CharacterRepository
import kz.bcc.school.data.repository.character.CharacterRepositoryImpl
import javax.inject.Singleton

@Module
abstract class CharacterRepositoryModule {

    @Binds
    @Singleton
    abstract fun bindCharacterRepository(impl: CharacterRepositoryImpl): CharacterRepository

}