package com.example.mvvm_animals

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.animals.Cats.CatResponce
import com.example.animals.Cats.ICatApi
import com.example.animals.Dogs.DogResponce
import com.example.animals.Dogs.IDogApi
import com.example.animals.Ducks.DuckResponce
import com.example.animals.Ducks.IDuckApi
import com.example.mvvm_animals.models.Consts
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainViewModel : ViewModel() {
    private val _imagesLiveData = MutableLiveData<String>()
    private val _errorMessageLiveData = MutableLiveData<String>()
    val imagesLiveData: LiveData<String>
        get() = _imagesLiveData
    val errorMessageLiveData: LiveData<String>
        get() = _errorMessageLiveData

    fun getCat(){
        val retrofitBuilder = retrofitRequest<ICatApi>(Consts.CAT_URL)
        val retrofitData = retrofitBuilder.getData()

        retrofitData.enqueue(object : Callback<CatResponce?> {
            override fun onResponse(call: Call<CatResponce?>,
                                    response: Response<CatResponce?>
            ) {
                val responseBody = response.body()!!
                _imagesLiveData.value = responseBody.imgUrl
            }

            override fun onFailure(call: Call<CatResponce?>, t: Throwable) {
                _errorMessageLiveData.value = Consts.ERROR_MSG
            }
        })
    }

    fun getDog(){
        val retrofitBuilder = retrofitRequest<IDogApi>(Consts.DOG_URL)
        val retrofitData = retrofitBuilder.getData()

        retrofitData.enqueue(object : Callback<DogResponce?> {
            override fun onResponse( call: Call<DogResponce?>,
                                     response: Response<DogResponce?>
            ) {
                val responseBody = response.body()!!
                _imagesLiveData.value = responseBody.imgUrl
            }

            override fun onFailure(call: Call<DogResponce?>, t: Throwable) {
                _errorMessageLiveData.value = Consts.ERROR_MSG
            }
        })
    }

    fun getDuck(){
        val retrofitBuilder = retrofitRequest<IDuckApi>(Consts.DUCK_URL)
        val retrofitData = retrofitBuilder.getData()

        retrofitData.enqueue(object : Callback<DuckResponce?> {
            override fun onResponse( call: Call<DuckResponce?>,
                                     response: Response<DuckResponce?>
            ) {
                val responseBody = response.body()!!
                _imagesLiveData.value = responseBody.imgUrl
            }

            override fun onFailure(call: Call<DuckResponce?>, t: Throwable) {
                _errorMessageLiveData.value = Consts.ERROR_MSG
            }
        })
    }

    private inline fun<reified T> retrofitRequest(url: String): T {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(url)
            .build()
            .create(T::class.java)
    }
}