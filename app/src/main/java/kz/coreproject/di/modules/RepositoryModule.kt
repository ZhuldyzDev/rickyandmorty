package kz.coreproject.di.modules

import dagger.Module
import kz.coreproject.di.modules.repository.AboutRepositoryModule

@Module(
    includes = [
        AboutRepositoryModule::class
    ]
)
class RepositoryModule {
}