package kz.bcc.school.network.exceptions

import kz.bcc.school.data.models.network.error.ApiError

class ApiException(val apiError: ApiError) : Exception()