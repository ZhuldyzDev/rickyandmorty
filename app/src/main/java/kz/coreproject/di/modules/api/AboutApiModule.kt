package kz.coreproject.di.modules.api

import dagger.Module
import dagger.Provides
import kz.coreproject.network.api.AboutApi
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class AboutApiModule {

    @Provides
    @Singleton
    fun provideActionsApi(retrofit: Retrofit): AboutApi {
        return retrofit.create(AboutApi::class.java)
    }

}