package kz.bcc.school.data.repository.error_handler

import android.app.Application
import com.google.gson.Gson
import bcc.school.app.R
import kz.bcc.school.data.models.network.Resource
import kz.bcc.school.data.models.network.error.ApiError
import kz.bcc.school.network.exceptions.ApiException
import kz.bcc.school.network.exceptions.ConnectionTimeOutException
import kz.bcc.school.network.exceptions.UnauthorizedException
import kz.bcc.school.network.exceptions.UnknownException
import okhttp3.ResponseBody
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class RepositoryErrorHandler
@Inject constructor(
    private val gson: Gson,
    private val app: Application
) {

    companion object {
        private const val OTHER = 400
        private const val UNAUTHORIZED = 401
    }

    /**
     *
     */
    fun <T> getError(httpStatusCode: Int?, errorBody: ResponseBody?): Resource<T> {
        val exception = handleError(httpStatusCode, errorBody)
        var message: String? = null

        when (exception) {
            is ApiException -> {
                message = exception.apiError.message
            }
            is ConnectionTimeOutException -> {
                message = app.getString(R.string.network_connection_error)
            }
            is UnknownException -> {
                message = app.getString(R.string.network_server_error)
            }
            is UnauthorizedException -> {
                message = exception.message
            }
        }

        return Resource.error(msg = message, data = null, exception = exception)
    }

    private fun handleError(httpStatusCode: Int?, errorBody: ResponseBody?): Exception =
        try {
            val error = gson.fromJson(errorBody?.string(), ApiError::class.java)

            when (httpStatusCode) {
                OTHER -> {
                    ApiException(error)
                }
                UNAUTHORIZED -> {
                    UnauthorizedException(error?.message)
                }
                else -> {
                    ApiException(error)
                }
            }

        } catch (e: Exception) {
            UnknownException()
        }

    /**
     *
     */
    fun <T> getError(e: Throwable): Resource<T> {
        val exception = handleError(e)
        var message: String? = null

        when (exception) {
            is ApiException -> {
                message = exception.apiError.message
            }
            is ConnectionTimeOutException -> {
                message = app.getString(R.string.network_connection_error)
            }
            is UnknownException -> {
                message = app.getString(R.string.network_server_error)
            }
            is UnauthorizedException -> {
                message = exception.message
            }
        }

        return Resource.error(msg = message, data = null, exception = exception)
    }

    private fun handleError(e: Throwable): Exception =
        when (e) {
            is HttpException -> {
                try {
                    val error =
                        gson.fromJson(e.response()?.errorBody()?.string(), ApiError::class.java)
                    when (e.code()) {
                        OTHER -> {
                            ApiException(error)
                        }
                        UNAUTHORIZED -> {
                            UnauthorizedException(error.message)
                        }
                        else -> {
                            ApiException(error)
                        }
                    }

                } catch (e: Exception) {
                    UnknownException()
                }
            }

            is IOException -> ConnectionTimeOutException()
            else -> UnknownException()
        }

}