package com.example.astra.presentation.api

import com.example.astra.presentation.list.Planet

data class PlanetListResponse(
    val bodies: List<Planet>
)