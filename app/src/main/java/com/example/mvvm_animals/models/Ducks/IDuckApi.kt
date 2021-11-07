package com.example.animals.Ducks

import retrofit2.Call
import retrofit2.http.GET

interface IDuckApi {

    @GET("random")
    fun getData() : Call<DuckResponce>
}