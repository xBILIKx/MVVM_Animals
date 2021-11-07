package com.example.animals.Cats

import com.example.animals.Dogs.DogResponce
import retrofit2.Call
import retrofit2.http.GET

interface ICatApi {
    @GET("meow")
    fun getData() : Call<CatResponce>
}