package kz.bcc.school.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import kz.bcc.school.data.db.dao.CartoonCharacterDao
import kz.bcc.school.data.models.CartoonCharacter
import kz.bcc.school.data.models.Origin

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

  /*  companion object {
        const val DATABASE_NAME = "rick_and_morty_db"
    }

    abstract fun cartoonCharacterDao(): CartoonCharacterDao*/