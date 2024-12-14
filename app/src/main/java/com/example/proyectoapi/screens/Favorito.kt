package com.example.proyectoapi.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.proyectoapi.navigation.InfoObj
import com.example.proyectoapi.viewModel.ViewModel

@Composable
fun FavoritoScreen(navController: NavController, viewModel:ViewModel, modifier: Modifier = Modifier) {
    Favorito(navController, viewModel, modifier)
}

@Composable
fun Favorito(navController: NavController, viewModel:ViewModel, modifier: Modifier = Modifier) {

    Column(modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {

        LazyColumn {
            items(viewModel.usuario.value.favoritos.size) {
                Spacer(Modifier.height(20.dp))
                val alimento = viewModel.usuario.value.favoritos[it]
                Alimentos(alimento) {
                    viewModel.changeAlimento(alimento)
                    navController.navigate(InfoObj(alimento.nombre, alimento.marca, alimento.labels, alimento.imageUrl, alimento.isFavorite))
                }
            }
        }

    }

}