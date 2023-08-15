package kz.test.rickandmorty.network.api

import kz.test.rickandmorty.data.models.CartoonCharacterList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface CharacterApi {

    @GET("character")
    suspend fun getCartoonCharacters(@Query("page") page: Int = 1): Response<CartoonCharacterList>

    @GET("character")
    suspend fun searchCharacters(
        @Query("name") name: String?,
      //  @Query("status") status: String?
    ): Response<CartoonCharacterList>
}