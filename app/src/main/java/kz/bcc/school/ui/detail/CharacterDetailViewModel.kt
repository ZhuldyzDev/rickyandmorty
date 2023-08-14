package kz.bcc.school.ui.detail

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import kz.bcc.school.data.models.CartoonCharacter
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

class CharacterDetailViewModel
@Inject constructor(
    private val app: Application
) : AndroidViewModel(app) {


}