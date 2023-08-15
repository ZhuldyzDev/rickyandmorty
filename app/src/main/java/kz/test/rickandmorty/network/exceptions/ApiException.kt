package kz.test.rickandmorty.network.exceptions

import kz.test.rickandmorty.data.network.error.ApiError


class ApiException(val apiError: ApiError) : Exception()