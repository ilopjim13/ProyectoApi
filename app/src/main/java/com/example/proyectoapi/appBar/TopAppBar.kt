package com.example.proyectoapi.appBar

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.CrueltyFree
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.StarBorder
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.proyectoapi.navigation.InfoObj
import com.example.proyectoapi.viewModel.ViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBar(navController:NavController,viewModel: ViewModel) {
    val alimento by rememberSaveable { viewModel.alimento }
    TopAppBar(
        title = {
            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Start
            ) {

                //Image(
                //    painter = painterResource(R.drawable.t),
                //    contentDescription = "Menu",
                //    modifier = Modifier.size(24.dp)
                //)
                //Icon(
                //    imageVector = Icons.Filled.CrueltyFree,
                //    contentDescription = "Menu"
                //)

                Text(
                    if (navController.currentBackStackEntryAsState().value?.destination?.route == "Menu") "Inicio"
                    else if (navController.currentBackStackEntryAsState().value?.destination?.route == "Api") "Api"
                    else if (navController.currentBackStackEntryAsState().value?.destination?.route == "Historial") "Historial"
                    else if (navController.currentBackStackEntryAsState().value?.destination?.route == "Favorito") "Favoritos"
                    else alimento?.nombre ?: ""

                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.White,
            titleContentColor = Color.Black,
            navigationIconContentColor = Color.Black,
            actionIconContentColor = Color.Black),
        actions = {
            if (alimento != null && navController.currentBackStackEntryAsState().value?.destination?.route != "Menu") {
                IconButton({
                    viewModel.changeIsFavorite()
                    viewModel.onClickFav(alimento)
                }) {
                    Icon(
                        imageVector = if(viewModel.checkFav(alimento)) Icons.Filled.Star else Icons.Filled.StarBorder,
                        contentDescription = "Favorito"
                    )
                }
                IconButton({ navController.popBackStack() }) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Volver"
                    )
                }
            }
            Icon(
                imageVector = Icons.Filled.MoreVert,
                contentDescription = ""
            )
        }
    )

}