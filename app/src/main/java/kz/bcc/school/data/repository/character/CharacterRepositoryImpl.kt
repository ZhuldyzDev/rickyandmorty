package kz.bcc.school.data.repository.character

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kz.bcc.school.data.db.dao.CartoonCharacterDao
import kz.bcc.school.data.models.CartoonCharacter
import kz.bcc.school.data.models.CartoonCharacterList
import kz.bcc.school.data.models.network.Resource
import kz.bcc.school.data.repository.error_handler.RepositoryErrorHandler
import kz.bcc.school.network.api.CharacterApi
import javax.inject.Inject

class CharacterRepositoryImpl
@Inject constructor(
    private val errorHandler: RepositoryErrorHandler,
    private val  api:CharacterApi,
    private val cartoonCharacterDao : CartoonCharacterDao
) : CharacterRepository {

    override fun getCartoonCharacters(page:Int): LiveData<Resource<CartoonCharacterList>> {
        return liveData {
            try {
                emit(
                    Resource.loading(null)
                )
                val request = api.getCartoonCharacters(page)
                with(request) {
                    if (isSuccessful) {
                        emit(
                            Resource.success(body())
                        )
                    } else {
                        emit(
                            errorHandler.getError(code(), errorBody())
                        )
                    }
                }
            } catch (e: Exception) {
                emit(
                    errorHandler.getError<CartoonCharacterList>(e)
                )
            }
        }
    }
    override fun searchCharacters(
        name: String?
    ): LiveData<Resource<CartoonCharacterList>> {
        return liveData {
            try {
                emit(
                    Resource.loading(null)
                )
                val request = api.searchCharacters(name)
                with(request) {
                    if (isSuccessful) {
                        emit(
                            Resource.success(body())
                        )
                    } else {
                        emit(
                            errorHandler.getError(code(), errorBody())
                        )
                    }
                }
            } catch (e: Exception) {
                emit(
                    errorHandler.getError<CartoonCharacterList>(e)
                )
            }
        }
    }

    override fun getAllCharacterFromDb(): LiveData<List<CartoonCharacter>> {
        return cartoonCharacterDao.getCartoonCharacters()
    }


    override fun saveCartoonCharactersToDatabase(cartoonCharacters: List<CartoonCharacter>) {
        CoroutineScope(Dispatchers.IO).launch {
            cartoonCharacterDao.saveCartoonCharacters(cartoonCharacters)
        }
    }

    override  fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            cartoonCharacterDao.deleteAllCartoonCharacters()
        }
    }

}