package kz.coreproject.data.enums.app

import coreproject.app.BuildConfig

enum class BroadcastEnums(val id: String) {

    FOREGROUND_PUSH("${BuildConfig.APPLICATION_ID}.foreground_push")

}