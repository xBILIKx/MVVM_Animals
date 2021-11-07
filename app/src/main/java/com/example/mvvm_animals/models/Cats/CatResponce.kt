package com.example.animals.Cats

import com.google.gson.annotations.SerializedName

data class CatResponce(
    @SerializedName("file")
    val imgUrl: String
)