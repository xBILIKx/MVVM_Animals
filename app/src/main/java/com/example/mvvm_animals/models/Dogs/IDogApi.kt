package com.example.animals.Dogs

import com.example.animals.Ducks.DuckResponce
import retrofit2.Call
import retrofit2.http.GET

interface IDogApi {

    @GET("breeds/image/random")
    fun getData() : Call<DogResponce>
}