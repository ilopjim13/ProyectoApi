package com.example.proyectoapi.screens

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.HideImage
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.proyectoapi.navigation.InfoObj


@Composable
fun InfoScreen(alimento: InfoObj, modifier: Modifier = Modifier) {
    Info(alimento, modifier)
}

@Composable
fun Info(alimento:InfoObj, modifier: Modifier = Modifier) {

    val scrollState = rememberScrollState()

    Column(modifier.fillMaxSize().verticalScroll(scrollState), horizontalAlignment = Alignment.CenterHorizontally) {

        Spacer(Modifier.height(40.dp))

        if (alimento.imageUrl != "null") {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(alimento.imageUrl)
                    .crossfade(true)
                    .build(),
                contentDescription = "Alimento Imagen",
                modifier = Modifier.size(220.dp)
            )
        } else{
            Icon(
                imageVector = Icons.Filled.HideImage,
                contentDescription = "Sin imagen",
                tint = Color.LightGray,
                modifier = Modifier.size(220.dp)
            )
        }


        Spacer(Modifier.height(40.dp))

        Column(
            Modifier
                .padding(start = 10.dp, end = 10.dp)
                .clip(RoundedCornerShape(10.dp))
                .border(2.dp, Color.Gray)
                .fillMaxWidth()) {

            Column(Modifier.padding(20.dp)) {
                Text(buildAnnotatedString { withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) { append("Nombre:") }
                    append(" ${alimento.nombre}") })
                Spacer(Modifier.height(15.dp))
                Text(if (alimento.marca == "null" || alimento.marca.isBlank()) {
                    buildAnnotatedString { withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) { append("Marca:") }
                        append(" Sin marca") }
                } else {
                    buildAnnotatedString { withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) { append("Marca:") }
                        append(" ${alimento.marca}") }
                })
                Spacer(Modifier.height(15.dp))
                Text(if (alimento.labels == "null" || alimento.labels.isBlank()) {
                    buildAnnotatedString { withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) { append("Etiquetas:") }
                        append(" Sin etiquetas") }
                } else {
                    buildAnnotatedString { withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) { append("Etiquetas:") }
                        append(" ${alimento.labels}") }
                })
            }

        }

    }
}
