package com.example.proyectoapi.navigation

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.proyectoapi.screens.ApiScreen
import com.example.proyectoapi.screens.FavoritoScreen
import com.example.proyectoapi.screens.HistorialScreen
import com.example.proyectoapi.screens.InfoScreen
import com.example.proyectoapi.screens.MenuScreen
import com.example.proyectoapi.screens.PortadaScreen

@Composable
fun Proyecto(modifier: Modifier = Modifier, navigationController:NavHostController) {
    NavHost(
        navController = navigationController,
        startDestination = "Portada"
    ) {
        composable("Portada") {
            PortadaScreen(navigationController)
        }
        composable("Menu") {
            MenuScreen(navigationController, modifier)
        }
        composable("Api") {
            ApiScreen(navigationController, modifier)
        }
        composable("Info") {
            InfoScreen(navigationController, modifier)
        }
        composable("Favorito") {
            FavoritoScreen(navigationController, modifier)
        }
        composable("Historial") {
            HistorialScreen(navigationController, modifier)
        }
    }
}