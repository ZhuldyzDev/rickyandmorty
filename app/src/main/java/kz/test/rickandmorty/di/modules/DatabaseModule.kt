package kz.test.rickandmorty.di.modules

import android.app.Application
import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import kz.test.rickandmorty.data.db.RickAndMortyDatabase
import kz.test.rickandmorty.data.db.dao.CartoonCharacterDao
import javax.inject.Singleton

@Module
class DatabaseModule {
    @Provides
    @Singleton
    fun provideDb(application: Application) = RickAndMortyDatabase.getDatabase(application)

    @Singleton
    @Provides
    fun provideCartoonCharacterDao(rickAndMortyDatabase: RickAndMortyDatabase): CartoonCharacterDao {
        return rickAndMortyDatabase.dao()
    }


}