package kz.test.rickandmorty.data.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kz.test.rickandmorty.data.models.CartoonCharacter

@Dao
interface CartoonCharacterDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveCartoonCharacters(cartoonCharacters: List<CartoonCharacter>)

    @Query("DELETE FROM cartoon_character")
    suspend fun deleteAllCartoonCharacters()

    @Query("SELECT * FROM cartoon_character")
    fun getCartoonCharacters(): LiveData<List<CartoonCharacter>>
}