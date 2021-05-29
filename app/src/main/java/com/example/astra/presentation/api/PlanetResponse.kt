package com.example.astra.presentation.api

import com.example.astra.presentation.list.Planet

data class PlanetResponse(
    val bodies: List<Planet>
)