package com.example.proyectoapi.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import coil.compose.AsyncImage
import coil.request.ImageRequest
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.proyectoapi.navigation.InfoObj
import com.example.proyectoapi.viewModel.ViewModel

@Composable
fun HistorialScreen(navController: NavController,viewModel: ViewModel, modifier: Modifier = Modifier) {
    Historial(navController,viewModel, modifier)
}

@Composable
fun Historial(navController: NavController, viewModel: ViewModel, modifier: Modifier = Modifier) {

    Column(modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        LazyColumn {
            items(viewModel.usuario.value.historial.size) {
                Spacer(Modifier.height(20.dp))
                val alimento = viewModel.usuario.value.historial[it]
                Alimentos(alimento) {
                    viewModel.changeAlimento(alimento)
                    navController.navigate(InfoObj(alimento.nombre, alimento.marca, alimento.labels, alimento.imageUrl, alimento.isFavorite))
                }
            }
        }

    }

}


@Composable
fun Alimentos(alimento:InfoObj, onClick:()-> Unit) {
    Row(Modifier.padding(end = 16.dp, start = 16.dp).fillMaxWidth().clickable(onClick = onClick), verticalAlignment = Alignment.CenterVertically) {
        Row(Modifier.padding(end = 16.dp, start = 16.dp).clip(RoundedCornerShape(20.dp)).background(Color(0xFFB1B1B7)).border(2.dp,Color.Black ).fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(alimento.imageUrl)
                    .crossfade(true)
                    .build(),
                contentDescription = "Alimento Imagen"
            )

            Spacer(Modifier.width(16.dp))

            Column {
                Text(alimento.nombre)
                Text(if (alimento.marca == "null") "Sin marca reconocida" else alimento.marca)
            }
        }

    }
}