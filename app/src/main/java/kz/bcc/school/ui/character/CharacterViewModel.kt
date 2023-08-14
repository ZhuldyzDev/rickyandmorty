package kz.bcc.school.ui.character

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import kz.bcc.school.data.models.CartoonCharacter
import kz.bcc.school.data.models.CartoonCharacterList
import kz.bcc.school.data.repository.character.CharacterRepository
import kz.bcc.school.ui_common.callbacks.RecyclerViewItemClickCallback
import kz.bcc.school.utils.live_data.Event
import javax.inject.Inject

class CharacterViewModel
@Inject constructor(
    private val app: Application,
    private val repository: CharacterRepository
) : AndroidViewModel(app) {

    fun onCharactersSuccess(characterList: CartoonCharacterList) {
        repository.clearAll()
        repository.saveCartoonCharactersToDatabase(characterList.cartoonCharacters)
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

    private val _btnClick = MutableLiveData<Event<CartoonCharacter>>()
    val btnClick: LiveData<Event<CartoonCharacter>>
        get() = _btnClick

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
                    _btnClick.postValue(Event(any))
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

}