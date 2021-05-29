package com.example.astra.presentation.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface PlanetApi {
    @GET("bodies")
    fun getPlanetList(): Call<PlanetListResponse>

    @GET("bodies/{id}")
    fun getPlanetDetail(@Path("id")id:String): Call<PlanetDetailResponse>
}