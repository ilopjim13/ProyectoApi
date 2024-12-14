package com.example.proyectoapi.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.StarBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.proyectoapi.navigation.InfoObj
import com.example.proyectoapi.viewModel.ViewModel


@Composable
fun InfoScreen(navController: NavController, viewModel: ViewModel, alimento: InfoObj, modifier: Modifier = Modifier) {
    Info(navController,viewModel, alimento, modifier)
}

@Composable
fun Info(navController: NavController, viewModel: ViewModel, alimento:InfoObj, modifier: Modifier = Modifier) {

    val isFavorite by rememberSaveable { viewModel.isFavorite }

    Column {
//        CabeceraInfo(alimento, viewModel, navController, modifier) {
//            viewModel.changeIsFavorite()
//            viewModel.onClickFav(alimento)
//        }

    }
}

@Composable
fun CabeceraInfo(alimento: InfoObj,viewModel: ViewModel, navController: NavController, modifier: Modifier, onClick:()->Unit) {
    Row(modifier = modifier.fillMaxWidth(),horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
        Text(alimento.nombre, fontSize = 28.sp)
        IconButton(onClick) {
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
}