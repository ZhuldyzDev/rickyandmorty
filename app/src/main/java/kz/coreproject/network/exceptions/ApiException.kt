package kz.coreproject.network.exceptions

import kz.coreproject.data.models.network.error.ApiError

class ApiException(val apiError: ApiError) : Exception()