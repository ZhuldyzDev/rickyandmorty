package kz.test.rickandmorty.data.repository.character

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kz.test.rickandmorty.data.db.dao.CartoonCharacterDao
import kz.test.rickandmorty.data.models.CartoonCharacter
import kz.test.rickandmorty.data.models.CartoonCharacterList
import kz.test.rickandmorty.data.models.network.Resource
import kz.test.rickandmorty.data.repository.error_handler.RepositoryErrorHandler
import kz.test.rickandmorty.network.api.CharacterApi
import javax.inject.Inject

class CharacterRepositoryImpl
@Inject constructor(
    private val errorHandler: RepositoryErrorHandler,
    private val  api: CharacterApi,
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