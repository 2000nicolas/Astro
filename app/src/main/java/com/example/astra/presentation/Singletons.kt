package com.example.astra.presentation

import com.example.astra.presentation.PlanetApplication.Companion.context
import com.example.astra.presentation.api.PlanetApi
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File

class Singletons{
    companion object{
        var cache = Cache(File(context?.cacheDir, "reponses"), 10*1024*1024)

        val okhttpClient: OkHttpClient = OkHttpClient().newBuilder()
                .cache(cache)
                .build()

        val planetApi: PlanetApi = Retrofit.Builder()
                .baseUrl("https://api.le-systeme-solaire.net/rest/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(okhttpClient)
                .build()
                .create(PlanetApi::class.java)


    }
}
