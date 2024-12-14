package com.example.proyectoapi.navigation

import kotlinx.serialization.Serializable

@Serializable
object Portada
@Serializable
object Menu
@Serializable
object Api
@Serializable
data class InfoObj(val nombre:String, val marca:String, val labels:String, val imageUrl:String, var isFavorite:Boolean = false)