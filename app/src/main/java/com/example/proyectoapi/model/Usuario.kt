package com.example.proyectoapi.model

data class Usuario(val username:String, val pass:String, val rol:String, val historial:List<Alimento>, val favoritos:List<Alimento> )