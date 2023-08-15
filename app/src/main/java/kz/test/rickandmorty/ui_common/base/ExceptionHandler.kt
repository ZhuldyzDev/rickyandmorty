package kz.test.rickandmorty.ui_common.base

import android.content.Context
import androidx.appcompat.app.AlertDialog
import kz.test.rickandmorty.R
import kz.test.rickandmorty.network.exceptions.ApiException
import kz.test.rickandmorty.network.exceptions.ConnectionTimeOutException
import kz.test.rickandmorty.network.exceptions.UnauthorizedException
import kz.test.rickandmorty.network.exceptions.UnknownException


object ExceptionHandler {

    fun handleExceptionDialog(context: Context, exception: Exception?) {

        fun showDialog(title: String, message: String) {
            AlertDialog
                .Builder(context!!)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton(context.getString(R.string.ok)) { dialog, which ->
                }
                .create()
                .show()
        }

        exception?.let {
            when (it) {
                is ApiException -> {
                    println("*****ERROR ${it.apiError.message}")

                    showDialog(
                        title = context.getString(R.string.network_error),
                        message = it.apiError.message ?: ""
                    )
                }
                is ConnectionTimeOutException -> {
                    showDialog(
                        title = context.getString(R.string.network_error),
                        message = context.getString(R.string.network_connection_error)
                    )
                }
                is UnknownException -> {
                    showDialog(
                        title = context.getString(R.string.network_error),
                        message = context.getString(R.string.network_server_error)
                    )
                }
                is UnauthorizedException -> {
                    showDialog(
                        title = context.getString(R.string.network_error),
                        message = context.getString(R.string.error_occurred)
                    )
                }
            }
        }

    }

}