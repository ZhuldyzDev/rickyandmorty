package kz.coreproject.data.models.language

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Language(
    val id: String,
    @StringRes val title: Int,
    @DrawableRes val icon: Int
)