package kz.coreproject.data.auth_state

import kz.coreproject.data.preferences.Preferences
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AuthState
@Inject constructor(
    private val preferences: Preferences
) {

    val isAuthorized: Boolean
        get() = preferences.getAppToken() != null

}