package com.example.proyectoapi.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForwardIos
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.proyectoapi.R

@Composable
fun PortadaScreen(navController: NavController, modifier: Modifier = Modifier) {
    Portada(navController, modifier)
}

@Composable
fun Portada(navController: NavController, modifier: Modifier = Modifier) {

    Column(modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.SpaceEvenly) {

        Image(
            painter = painterResource(R.drawable.logo),
            contentDescription = "Logo"
        )

        Text("Bienvenido a ....")

        Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.padding(end = 60.dp, start = 60.dp).fillMaxWidth()) {
            Button(
                onClick = {navController.navigate("Menu")},
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFD8B15)
            ) ) {
                Row(horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                    Text("Comenzar")
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowForwardIos,
                        contentDescription = "Comenzar",
                        modifier = Modifier.size(16.dp)
                    )
                }

            }
        }

    }




}