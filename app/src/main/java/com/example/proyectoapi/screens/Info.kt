package com.example.proyectoapi.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.StarBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController


@Composable
fun InfoScreen(navController: NavController, modifier: Modifier = Modifier) {
    Info(navController, modifier)
}

@Composable
fun Info(navController: NavController, modifier: Modifier = Modifier) {

}

@Composable
fun CabeceraInfo(titulo:String,isFavorite:Boolean, onClick:()->Unit, modifier: Modifier) {
    Row(modifier = modifier.fillMaxWidth(),horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
        Text(titulo)
        IconButton(onClick) {
            Icon(
                imageVector = if(isFavorite) Icons.Filled.Star else Icons.Filled.StarBorder,
                contentDescription = "Opciones"
            )
        }

        Icon(
            imageVector = Icons.Filled.MoreVert,
            contentDescription = "Opciones"
        )
    }
}