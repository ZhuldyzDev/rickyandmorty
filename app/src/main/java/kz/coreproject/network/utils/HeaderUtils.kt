package kz.coreproject.network.utils

import android.os.Build
import coreproject.app.BuildConfig
import kz.coreproject.data.preferences.Preferences
import javax.inject.Inject

class HeaderUtils
@Inject constructor(
    private val preferences: Preferences,
    private val uniqueID: UniqueID
) {

    fun getAccept(): String = "application/json"

    fun getDeviceId(): String = uniqueID.id()

    fun getAppToken(): String = preferences.getAppToken() ?: ""

    fun getAppVersion(): String = BuildConfig.VERSION_NAME

    fun getLang(): String = preferences.getLanguage() ?: ""

    fun getDeviceBrand(): String = Build.MANUFACTURER

    fun getDeviceModel(): String = Build.MODEL

    fun getDeviceOs(): String = Build.VERSION.RELEASE

    fun getDeviceOsMain(): String = "android"

    fun getDeviceAddInfo(): String = ""

}