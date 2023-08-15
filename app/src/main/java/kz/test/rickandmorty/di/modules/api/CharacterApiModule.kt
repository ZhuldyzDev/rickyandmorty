package kz.test.rickandmorty.di.modules.api

import dagger.Module
import dagger.Provides
import kz.test.rickandmorty.network.api.CharacterApi
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