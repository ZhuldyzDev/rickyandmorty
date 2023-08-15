package kz.test.rickandmorty.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import kz.test.rickandmorty.data.db.dao.CartoonCharacterDao
import kz.test.rickandmorty.data.models.CartoonCharacter
import kz.test.rickandmorty.data.models.Origin

@Database(
    entities = [
        CartoonCharacter::class,
        Origin::class
    ],
    version = 1,
    exportSchema = false
)
abstract class RickAndMortyDatabase : RoomDatabase() {
        abstract fun dao(): CartoonCharacterDao
        companion object{
            @Volatile
            private var INSTANCE: RickAndMortyDatabase? = null

            fun getDatabase(context: Context): RickAndMortyDatabase{
                val tempInstance = INSTANCE
                if (tempInstance != null){
                    return tempInstance
                }
                synchronized(this){
                    val instance = Room.databaseBuilder(
                        context.applicationContext,
                        RickAndMortyDatabase::class.java,
                        "appDB"
                    ).build()
                    INSTANCE = instance
                    return instance
                }
            }


        }

    }