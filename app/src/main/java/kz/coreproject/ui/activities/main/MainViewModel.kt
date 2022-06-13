package kz.coreproject.ui.activities.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import kz.coreproject.data.preferences.Preferences
import javax.inject.Inject

class MainViewModel
@Inject constructor(
    private val app: Application,
    private val preferences: Preferences
) : AndroidViewModel(app) {

}