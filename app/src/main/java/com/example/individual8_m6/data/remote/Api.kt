package com.example.individual8_m6.data.remote

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface Api {

    @GET("breeds/list/all")
    suspend fun getDataPerros(): Response<RazaPerros>

    @GET("breed/{id}/images")
    suspend fun getDetallePerro(@Path("id") id: String): Response<DogDetail>


}