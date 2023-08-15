package kz.test.rickandmorty.di.modules

import dagger.Module
import kz.test.rickandmorty.di.modules.api.CharacterApiModule

@Module(
    includes = [
        CharacterApiModule::class
    ]
)
class ApiModule {
}