package kz.bcc.school.data.enums.app

import bcc.school.app.BuildConfig

enum class BroadcastEnums(val id: String) {

    FOREGROUND_PUSH("${BuildConfig.APPLICATION_ID}.foreground_push")

}