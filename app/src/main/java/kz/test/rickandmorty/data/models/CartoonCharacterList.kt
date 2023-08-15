package kz.test.rickandmorty.data.models


import com.google.gson.annotations.SerializedName

data class CartoonCharacterList(
    @SerializedName("info")
    val info: Info,
    @SerializedName("results")
    val cartoonCharacters: List<CartoonCharacter>
)