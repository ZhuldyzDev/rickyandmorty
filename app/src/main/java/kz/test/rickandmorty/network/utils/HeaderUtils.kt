package  kz.test.rickandmorty.network.utils

import android.os.Build
import kz.test.rickandmorty.BuildConfig
import javax.inject.Inject

class HeaderUtils
@Inject constructor(
) {

    fun getAccept(): String = "application/json"


    fun getAppVersion(): String = BuildConfig.VERSION_NAME


    fun getDeviceBrand(): String = Build.MANUFACTURER

    fun getDeviceModel(): String = Build.MODEL

    fun getDeviceOs(): String = Build.VERSION.RELEASE

    fun getDeviceOsMain(): String = "android"

    fun getDeviceAddInfo(): String = ""

}