package com.example.astra.presentation

import com.example.astra.presentation.api.PlanetApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Singletons{
    companion object{

        val planetApi: PlanetApi = Retrofit.Builder()
                .baseUrl("https://api.le-systeme-solaire.net/rest/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(PlanetApi::class.java)
    }
}
