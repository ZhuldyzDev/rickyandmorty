package kz.bcc.school.data.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kz.bcc.school.data.models.CartoonCharacter

@Dao
interface CartoonCharacterDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveCartoonCharacters(cartoonCharacters: List<CartoonCharacter>)

    @Query("DELETE FROM cartoon_character")
    suspend fun deleteAllCartoonCharacters()

    @Query("SELECT * FROM cartoon_character")
    fun getCartoonCharacters(): LiveData<List<CartoonCharacter>>
}