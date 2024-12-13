package com.example.proyectoapi.navigation

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.proyectoapi.screens.ApiScreen
import com.example.proyectoapi.screens.InfoScreen
import com.example.proyectoapi.screens.MenuScreen
import com.example.proyectoapi.screens.PortadaScreen

@Composable
fun Proyecto(modifier: Modifier = Modifier) {
    val navigationController = rememberNavController()
    NavHost(
        navController = navigationController,
        startDestination = Portada
    ) {
        composable<Portada> {
            PortadaScreen(navigationController)
        }
        composable<Menu> {
            MenuScreen(navigationController)
        }
        composable<Api> {
            ApiScreen(navigationController)
        }
        composable<Info> {
            InfoScreen(navigationController)
        }
    }
}