package kz.bcc.school.di.modules

import dagger.Module
import kz.bcc.school.di.modules.repository.AboutRepositoryModule

@Module(
    includes = [
        AboutRepositoryModule::class
    ]
)
class RepositoryModule {
}