package kz.coreproject.ui.activities.splash

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import kz.coreproject.data.preferences.Preferences
import javax.inject.Inject

class SplashViewModel
@Inject constructor(
    private val app: Application
) : AndroidViewModel(app) {

}