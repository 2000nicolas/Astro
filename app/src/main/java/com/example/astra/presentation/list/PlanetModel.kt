package com.example.astra.presentation.list

sealed class PlanetModel

data class PlanetSuccess(val planetList: List<Planet>) : PlanetModel()
object PlanetLoader : PlanetModel()
object PlanetError : PlanetModel()