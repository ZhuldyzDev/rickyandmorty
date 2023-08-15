package kz.test.rickandmorty.data.repository.character

import androidx.lifecycle.LiveData
import kz.test.rickandmorty.data.models.CartoonCharacter
import kz.test.rickandmorty.data.models.CartoonCharacterList
import kz.test.rickandmorty.data.models.network.Resource

interface CharacterRepository {

    fun getCartoonCharacters(page: Int): LiveData<Resource<CartoonCharacterList>>

    fun searchCharacters(name: String?): LiveData<Resource<CartoonCharacterList>>


    fun saveCartoonCharactersToDatabase(cartoonCharacters: List<CartoonCharacter>)

    fun clearAll()

    fun getAllCharacterFromDb(): LiveData<List<CartoonCharacter>>
}