package kz.coreproject.di.modules.repository

import dagger.Binds
import dagger.Module
import kz.coreproject.data.repository.about.AboutRepository
import kz.coreproject.data.repository.about.AboutRepositoryImpl
import javax.inject.Singleton

@Module
abstract class AboutRepositoryModule {

    @Binds
    @Singleton
    abstract fun bindAboutRepository(impl: AboutRepositoryImpl): AboutRepository

}