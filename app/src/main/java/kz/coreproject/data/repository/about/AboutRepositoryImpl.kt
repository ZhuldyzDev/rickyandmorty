package kz.coreproject.data.repository.about

import kz.coreproject.data.preferences.Preferences
import kz.coreproject.data.repository.error_handler.RepositoryErrorHandler
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