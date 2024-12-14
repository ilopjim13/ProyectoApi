package com.example.proyectoapi.screens

import androidx.compose.foundation.Image
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.proyectoapi.R
import com.example.proyectoapi.navigation.InfoObj
import com.example.proyectoapi.viewModel.ViewModel
import kotlinx.coroutines.launch

@Composable
fun MenuScreen(navController: NavController, viewModel: ViewModel, modifier: Modifier) {
    Menu(navController, viewModel, modifier)
}

@Composable
fun Menu(navController: NavController, viewModel: ViewModel, modifier: Modifier = Modifier) {

    val isRandom by rememberSaveable { viewModel.isRandom }
    val alimento by remember { viewModel.alimento }
    val coroutineScope = rememberCoroutineScope()

    Column(modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {

        Spacer(Modifier.height(30.dp))

        Image(
            painter = painterResource(R.drawable.pngegg),
            contentDescription = "",
            Modifier.clickable {
                coroutineScope.launch {
                    val alimentoRandom = viewModel.getAlimentoRandom()
                    viewModel.changeAlimento(alimentoRandom)
                    viewModel.changeIsRandom()
                }

            }
        )
        Spacer(Modifier.height(15.dp))
        Text("Clícame", fontSize = 22.sp)

        if (isRandom) {
            Spacer(Modifier.height(30.dp))
            Text("Alimento que te podría interesar")
            Spacer(Modifier.height(15.dp))

            AlimentosRandom(alimento) {
                navController.navigate(InfoObj(alimento?.nombre ?:"", alimento?.marca?:"", alimento?.labels?:"", alimento?.imageUrl?:"", alimento?.isFavorite?:false))
            }



        }

    }

}

@Composable
fun AlimentosRandom(alimento:InfoObj?, onClick:()-> Unit) {
    Row(Modifier.padding(end = 16.dp, start = 16.dp).fillMaxWidth().clickable(onClick = onClick), verticalAlignment = Alignment.CenterVertically) {
        Row(Modifier.padding(end = 16.dp, start = 16.dp).clip(RoundedCornerShape(20.dp)).background(Color(0xFFB1B1B7)).border(2.dp,Color.Black ).fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(alimento?.imageUrl)
                    .crossfade(true)
                    .build(),
                contentDescription = "Alimento Imagen"
            )

            Spacer(Modifier.width(16.dp))

            Column {
                Text(alimento?.nombre?: "")
                Text(if (alimento?.marca == "null") "Sin marca reconocida" else alimento?.marca ?: "")
            }
        }

    }
}

