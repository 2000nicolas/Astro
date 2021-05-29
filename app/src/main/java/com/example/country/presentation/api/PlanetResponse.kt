package com.example.country.presentation.api

import com.example.country.presentation.list.Planet

data class PlanetResponse(
    val bodies: List<Planet>
)