package kz.bcc.school.di.modules

import dagger.Module
import kz.bcc.school.di.modules.api.AboutApiModule

@Module(
    includes = [
        AboutApiModule::class
    ]
)
class ApiModule {
}