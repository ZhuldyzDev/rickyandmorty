package kz.test.rickandmorty.utils.bind

import android.graphics.Color
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import kz.test.rickandmorty.utils.downloadFromUrl
import kz.test.rickandmorty.utils.placeholderProgressBar
import java.util.*

@BindingAdapter("android:downloadUrl")
fun downloadImage(view: ImageView, url: String?) {
    view.downloadFromUrl(url, placeholderProgressBar(view.context))
}


@BindingAdapter("android:lifeStatusColor")
fun setColorOfLifeStatus(view: TextView, lifeStatus: Int) {
    when (lifeStatus) {
        1 -> {
            view.setTextColor(Color.GREEN)
        }
        -1 -> {
            view.setTextColor(Color.RED)
        }
        else -> {
            view.setTextColor(Color.GRAY)
        }
    }
}