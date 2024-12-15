package com.example.proyectoapi.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.example.proyectoapi.screens.ApiScreen
import com.example.proyectoapi.screens.FavoritoScreen
import com.example.proyectoapi.screens.HistorialScreen
import com.example.proyectoapi.screens.InfoScreen
import com.example.proyectoapi.screens.MenuScreen
import com.example.proyectoapi.screens.PortadaScreen
import com.example.proyectoapi.viewModel.ViewModel

@Composable
fun Proyecto(modifier: Modifier = Modifier, viewModel: ViewModel, navigationController:NavHostController) {
    NavHost(
        navController = navigationController,
        startDestination = "Portada"
    ) {
        composable("Portada") {
            PortadaScreen(navigationController)
        }
        composable("Menu") {
            MenuScreen(navigationController,viewModel, modifier)
        }
        composable("Api") {
            ApiScreen(navigationController, viewModel, modifier)
        }
        composable<InfoObj> {
            val args = it.toRoute<InfoObj>()
            InfoScreen(args, modifier)
        }
        composable("Favorito") {
            FavoritoScreen(navigationController, viewModel, modifier)
        }
        composable("Historial") {
            HistorialScreen(navigationController, viewModel, modifier)
        }
    }
}