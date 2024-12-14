package com.example.proyectoapi.model

import androidx.compose.runtime.snapshots.SnapshotStateList
import com.example.proyectoapi.navigation.InfoObj

data class Usuario(val username:String, val pass:String, val rol:String, val historial:SnapshotStateList<InfoObj>, val favoritos:SnapshotStateList<InfoObj> )