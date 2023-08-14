package kz.bcc.school.utils

import android.content.Context
import android.graphics.Color
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import bcc.school.app.R
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions


fun ImageView.downloadFromUrl(url: String?, progressDrawable: CircularProgressDrawable) {
    val options = RequestOptions()
        .placeholder(progressDrawable)
        .error(R.drawable.ic_baseline_report_problem_24)

    Glide.with(context)
        .setDefaultRequestOptions(options)
        .load(url)
        .into(this)
}
fun placeholderProgressBar(context: Context): CircularProgressDrawable {
    return CircularProgressDrawable(context).apply {
        strokeWidth = 8F
        centerRadius = 40F
        start()
    }
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