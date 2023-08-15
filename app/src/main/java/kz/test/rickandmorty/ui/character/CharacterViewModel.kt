package kz.test.rickandmorty.ui.character

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import kz.test.rickandmorty.data.models.CartoonCharacter
import kz.test.rickandmorty.data.models.CartoonCharacterList
import kz.test.rickandmorty.data.repository.character.CharacterRepository
import kz.test.rickandmorty.ui_common.callbacks.RecyclerViewItemClickCallback
import kz.test.rickandmorty.utils.live_data.Event
import javax.inject.Inject

class CharacterViewModel
@Inject constructor(
    private val app: Application,
    private val repository: CharacterRepository
) : AndroidViewModel(app) {

    private val _charactersList = MutableLiveData<List<CartoonCharacter>>()
    val charactersList: LiveData<List<CartoonCharacter>>
        get() = _charactersList

    fun onCharactersSuccess(characterList: CartoonCharacterList) {
        if(_charactersList.value.isNullOrEmpty())  {
            repository.saveCartoonCharactersToDatabase(characterList.cartoonCharacters)
        }
        _listCharacterLD.postValue(characterList)
    }

    var page = 1
    private val getCharacters = MutableLiveData<Int>()

    val getCharactersResource =
        Transformations.switchMap(getCharacters) {
            repository.getCartoonCharacters(it)
        }

    private val refresh = MutableLiveData<Unit>()

    init {
        refresh.postValue(Unit)
    }


    val getAllCharacterFromDB: LiveData<List<CartoonCharacter>> =
        Transformations.switchMap(refresh) {
            repository.getAllCharacterFromDb()
        }


    private val searchCharacters = MutableLiveData<String>()

    val searchResource =
        Transformations.switchMap(searchCharacters) {
            repository.searchCharacters(it)
        }

    private val _itemClick = MutableLiveData<Event<CartoonCharacter>>()
    val itemClick: LiveData<Event<CartoonCharacter>>
        get() = _itemClick

    init {
        getCharacters.postValue(page)
    }

    private val _listCharacterLD = MutableLiveData<CartoonCharacterList>()
    val listCharacterLD: LiveData<CartoonCharacterList>
        get() = _listCharacterLD

    val recyclerViewItemClickCallback = object : RecyclerViewItemClickCallback {
        override fun onRecyclerViewItemClick(any: Any) {
            when (any) {
                is CartoonCharacter -> {
                    _itemClick.postValue(Event(any))
                }
            }
        }
    }

    fun onButtonNext() {
        page++
        getCharacters.postValue(page)
    }

    fun onButtonBack() {
        page--
        getCharacters.postValue(page)
    }

    fun searchCharacter(name: CharSequence) {
        searchCharacters.postValue(name.toString())
    }

    fun setAllCharacterFromDB(it: List<CartoonCharacter>?) {
        _charactersList.postValue(it)
    }

}