package com.example.proyectoapi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.proyectoapi.appBar.BottomBar
import com.example.proyectoapi.appBar.MyTopAppBar
import com.example.proyectoapi.navigation.Proyecto
import com.example.proyectoapi.ui.theme.ProyectoApiTheme
import com.example.proyectoapi.viewModel.ViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProyectoApiTheme(darkTheme = false) {
                val navController = rememberNavController()
                val viewModel = ViewModel()
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = {if(navController.currentBackStackEntryAsState().value?.destination?.route != "Portada") { MyTopAppBar(navController, viewModel) } },
                    bottomBar = { if(navController.currentBackStackEntryAsState().value?.destination?.route != "Portada") { BottomBar(navController, viewModel) } }
                ) { innerPadding ->
                    Proyecto(
                        navigationController = navController,
                        modifier = Modifier.padding(innerPadding),
                        viewModel = viewModel
                    )
                }
            }
        }
    }
}
