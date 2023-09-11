package com.example.individual8_m6.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class DogRetrofit {

    companion object{

        private const val BASE_URL = "https://dog.ceo/api/"

        fun gesRetroFitAves(): Api{

            val mRetrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return mRetrofit.create(Api::class.java)

        }


    }

}