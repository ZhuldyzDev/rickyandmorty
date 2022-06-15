package kz.bcc.school.network.utils

import android.os.Build
import bcc.school.app.BuildConfig
import kz.bcc.school.data.preferences.Preferences
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