package com.example.astra.presentation.api

data class PlanetDetailResponse(
        val name: String,
        val englishName: String,
        val isPlanet: String,
        val mass: ValueAndExpo,
        val density: Double,
        val gravity: Double
)

data class ValueAndExpo (
    val massValue:Double,
    val massExponent:Int
)


