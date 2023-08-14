package kz.bcc.school.di.modules

import dagger.Module
import kz.bcc.school.di.modules.api.CharacterApiModule

@Module(
    includes = [
        CharacterApiModule::class
    ]
)
class ApiModule {
}