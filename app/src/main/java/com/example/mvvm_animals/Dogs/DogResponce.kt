package com.example.animals.Dogs

import com.google.gson.annotations.SerializedName

data class DogResponce(

    @SerializedName("message")
    var imgUrl: String,

    @SerializedName("status")
    var status: String

)
