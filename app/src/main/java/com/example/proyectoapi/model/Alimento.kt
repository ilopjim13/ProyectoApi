package com.example.proyectoapi.model

data class Alimento(val nombre:String, val marca:String, val etiqueta:String, val imagenUrl:String, var isFavorite:Boolean = false)