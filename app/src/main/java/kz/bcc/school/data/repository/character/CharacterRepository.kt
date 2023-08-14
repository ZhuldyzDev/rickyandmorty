package kz.bcc.school.data.repository.character

import androidx.lifecycle.LiveData
import kz.bcc.school.data.models.CartoonCharacter
import kz.bcc.school.data.models.CartoonCharacterList
import kz.bcc.school.data.models.network.Resource

interface CharacterRepository {

     fun getCartoonCharacters(page:Int): LiveData<Resource<CartoonCharacterList>>

     fun searchCharacters(name: String?): LiveData<Resource<CartoonCharacterList>>


     fun saveCartoonCharactersToDatabase(cartoonCharacters: List<CartoonCharacter>)

      fun clearAll()

     fun getAllCharacterFromDb(): LiveData<List<CartoonCharacter>>
}