package kz.bcc.school.data.repository.about

import kz.bcc.school.data.preferences.Preferences
import kz.bcc.school.data.repository.error_handler.RepositoryErrorHandler
import javax.inject.Inject

class AboutRepositoryImpl
@Inject constructor(
    private val errorHandler: RepositoryErrorHandler,
    private val preferences: Preferences
) : AboutRepository {

//    override fun getActions(params: Map<String, String>): LiveData<Resource<Actions>> {
//        return liveData {
//            try {
//                emit(
//                    Resource.loading(null)
//                )
//
//                val request = api.getActions(params)
//                with(request) {
//                    if (isSuccessful) {
//                        emit(
//                            Resource.success(body())
//                        )
//                    } else {
//                        emit(
//                            errorHandler.getError(code(), errorBody())
//                        )
//                    }
//                }
//            } catch (e: Exception) {
//                emit(
//                    errorHandler.getError<Actions>(e)
//                )
//            }
//        }
//    }
//
//    override fun getAction(id: String): LiveData<Resource<ActionResponse>> {
//        return liveData {
//            try {
//                emit(
//                    Resource.loading(null)
//                )
//
//                val request = api.getAction(id)
//                with(request) {
//                    if (isSuccessful) {
//                        emit(
//                            Resource.success(body())
//                        )
//                    } else {
//                        emit(
//                            errorHandler.getError(code(), errorBody())
//                        )
//                    }
//                }
//            } catch (e: Exception) {
//                emit(
//                    errorHandler.getError<ActionResponse>(e)
//                )
//            }
//        }
//    }

}