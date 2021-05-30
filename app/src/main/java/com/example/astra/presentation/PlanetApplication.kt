package com.example.astra.presentation

import android.app.Application
import android.content.Context

class PlanetApplication : Application() {
    companion object{
        var context: Context? = null
    }

    override fun onCreate() {
        super.onCreate()
        context=this
    }
}