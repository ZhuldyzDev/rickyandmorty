package kz.bcc.school.di.modules

import dagger.Module
import kz.bcc.school.di.modules.repository.CharacterRepositoryModule

@Module(
    includes = [
        CharacterRepositoryModule::class
    ]
)
class RepositoryModule {
}