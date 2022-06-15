package kz.bcc.school.data.models.custom

import android.os.Parcelable
import androidx.annotation.StringRes
import kotlinx.android.parcel.Parcelize
import bcc.school.app.R

@Parcelize
data class TitleValue(
    val id: String = "",
    @StringRes val title: Int,
    val value: String = "",
    val icon: Int = R.color.transparent
) : Parcelable