package kz.bcc.school.ui_common.base

import android.content.Context
import androidx.appcompat.app.AlertDialog
import bcc.school.app.R
import kz.bcc.school.network.exceptions.ApiException
import kz.bcc.school.network.exceptions.ConnectionTimeOutException
import kz.bcc.school.network.exceptions.UnauthorizedException
import kz.bcc.school.network.exceptions.UnknownException

object ExceptionHandler {

    fun handleException(context: Context, exception: Exception?) {
        exception?.let {
            when (it) {
                is UnauthorizedException -> {
//                    val intent = UnauthorizedActivity.getIntentNewTask(context!!)
//                    context.startActivity(intent)
                }
            }
        }
    }

    fun handleExceptionView(context: Context, exception: Exception?) {
        exception?.let {
            when (it) {

            }
        }
    }

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
//                    val intent = UnauthorizedActivity.getIntentNewTask(context!!)
//                    context.startActivity(intent)
                }
            }
        }

    }

    fun showErrorDialog(context: Context, title: String, message: String) {
        AlertDialog
            .Builder(context)
            .setTitle(title)
            .setMessage(message)
            .setPositiveButton(context.getString(R.string.ok)) { dialog, which ->
            }
            .create()
            .show()
    }

}