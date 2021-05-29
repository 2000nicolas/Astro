package com.example.country.presentation.api

import retrofit2.Call
import retrofit2.http.GET

interface PlanetApi {
    @GET("bodies")
    fun getCountryList(): Call<PlanetResponse>//commence par des [] donc list !!
}