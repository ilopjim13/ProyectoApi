package com.example.proyectoapi.appBar

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.proyectoapi.viewModel.ViewModel

@Composable
fun BottomBar(navController: NavHostController, viewModel: ViewModel) {
    var index by remember { mutableIntStateOf(0) }
    val ruta = navController.currentBackStackEntryAsState()
    NavigationBar(containerColor = Color.White) {
        NavigationBarItem(
            selected = index == 0,
            onClick = {index = 0},
            colors = NavigationBarItemDefaults.colors(
                indicatorColor = if(navController.currentBackStackEntryAsState().value?.destination?.route == "Menu") Color(0xFF00941D) else Color.White,
                selectedTextColor = Color.Black,
                unselectedTextColor = Color.Gray,
                selectedIconColor = if(navController.currentBackStackEntryAsState().value?.destination?.route == "Menu") Color.White else Color.Black,
                unselectedIconColor = Color.Gray
            ),
            icon = {
                IconButton({
                    if (ruta.value?.destination?.route != "Menu") {
                        navController.navigate("Menu")
                        viewModel.resetVariable()
                    }

                }) {
                    Icon(
                        imageVector = Icons.Filled.Home,
                        contentDescription = "Home"
                    )
                }

            },
            label = { Text("Home")}
        )
        NavigationBarItem(
            selected = index == 0,
            onClick = {index = 0},
            colors = NavigationBarItemDefaults.colors(
                indicatorColor = if(navController.currentBackStackEntryAsState().value?.destination?.route == "Api") Color(0xFF00941D) else Color.White,
                selectedTextColor = Color.Black,
                unselectedTextColor = Color.Gray,
                selectedIconColor = if(navController.currentBackStackEntryAsState().value?.destination?.route == "Api") Color.White else Color.Black,
                unselectedIconColor = Color.Gray
            ),
            icon = {
                IconButton({
                    if (ruta.value?.destination?.route != "Api") {
                        navController.navigate("Api")
                        viewModel.resetVariable()
                    }
                }) {
                    Icon(
                        imageVector = Icons.Filled.Search,
                        contentDescription = "Api"
                    )
                }
            },
            label = { Text("Api")}
        )
        NavigationBarItem(
            selected = index == 0,
            onClick = {index = 0},
            colors = NavigationBarItemDefaults.colors(
                indicatorColor = if(navController.currentBackStackEntryAsState().value?.destination?.route == "Historial") Color(0xFF00941D) else Color.White,
                selectedTextColor = Color.Black,
                unselectedTextColor = Color.Gray,
                selectedIconColor = if(navController.currentBackStackEntryAsState().value?.destination?.route == "Historial") Color.White else Color.Black,
                unselectedIconColor = Color.Gray
            ),
            icon = {
                IconButton({
                    if (ruta.value?.destination?.route != "Historial") {
                        navController.navigate("Historial")
                        viewModel.resetVariable()
                    }
                }) {
                    Icon(
                        imageVector = Icons.Filled.History,
                        contentDescription = "Historial"
                    )
                }

            },
            label = { Text("Historial")}
        )
        NavigationBarItem(
            selected = index == 0,
            onClick = {index = 0},
            colors = NavigationBarItemDefaults.colors(
                indicatorColor = if(navController.currentBackStackEntryAsState().value?.destination?.route == "Favorito") Color(0xFF00941D) else Color.White,
                selectedTextColor = Color.Black,
                unselectedTextColor = Color.Gray,
                selectedIconColor = if(navController.currentBackStackEntryAsState().value?.destination?.route == "Favorito") Color.White else Color.Black,
                unselectedIconColor = Color.Gray
            ),
            icon = {

                IconButton({
                    if (ruta.value?.destination?.route != "Favorito") {
                        navController.navigate("Favorito")
                        viewModel.resetVariable()
                    }
                }) {
                    Icon(
                        imageVector = Icons.Filled.Star,
                        contentDescription = "Favoritos"
                    )
                }

            },
            label = { Text("Favoritos")}
        )
    }
}