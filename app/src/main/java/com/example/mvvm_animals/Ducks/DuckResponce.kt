package com.example.animals.Ducks

import com.google.gson.annotations.SerializedName

data class DuckResponce(

    @SerializedName("url")
    var imgUrl: String,

    @SerializedName("message")
    var msg: String
)