package kz.coreproject.di.modules

import dagger.Module
import kz.coreproject.di.modules.api.AboutApiModule

@Module(
    includes = [
        AboutApiModule::class
    ]
)
class ApiModule {
}