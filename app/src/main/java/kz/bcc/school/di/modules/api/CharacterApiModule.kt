package kz.bcc.school.di.modules.api

import dagger.Module
import dagger.Provides
import kz.bcc.school.network.api.CharacterApi
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class CharacterApiModule {

    @Provides
    @Singleton
    fun provideActionsApi(retrofit: Retrofit): CharacterApi {
        return retrofit.create(CharacterApi::class.java)
    }

}