package kz.test.rickandmorty.di.modules

import dagger.Module
import kz.test.rickandmorty.di.modules.repository.CharacterRepositoryModule

@Module(
    includes = [
        CharacterRepositoryModule::class
    ]
)
class RepositoryModule {
}