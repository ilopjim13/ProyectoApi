package com.example.proyectoapi.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.proyectoapi.R
import com.example.proyectoapi.navigation.InfoObj
import com.example.proyectoapi.service.ApiService
import com.example.proyectoapi.viewModel.ViewModel
import kotlinx.coroutines.launch

@Composable
fun ApiScreen(navController: NavController, viewModel: ViewModel, modifier: Modifier = Modifier) {
    Api(navController, viewModel, modifier)
}

@Composable
fun Api(navController: NavController, viewModel: ViewModel, modifier: Modifier = Modifier) {

    val code by rememberSaveable { viewModel.code }
    val error by rememberSaveable { viewModel.error }
    val coroutineScope = rememberCoroutineScope()

    Column(modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {

        Spacer(Modifier.height(120.dp))

        Image(
            painter = painterResource(R.drawable.logo),
            contentDescription = "logo"
        )
        Spacer(Modifier.height(40.dp))
        OutlinedTextField(
            value = code,
            onValueChange = {
                viewModel.onChangeCode(it)
                viewModel.changeError(false) },
            placeholder = { Text("Introduce el código del producto...")},
            label = { Text("Código")}
        )
        Spacer(Modifier.height(40.dp))

        Button(
            onClick = {
            coroutineScope.launch{
                val alimento:InfoObj? = ApiService.getAlimento(code)
                if (alimento == null) {
                    viewModel.changeError(true)
                } else {
                    val aliment = InfoObj(alimento.nombre,alimento.marca, alimento.labels, alimento.imageUrl)
                    viewModel.changeAlimento(aliment)
                    viewModel.changeError(false)
                    viewModel.addHistorial(aliment)
                    navController.navigate(aliment)
                    }
                }
            },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFD8B15)),
            modifier = Modifier.padding(end = 65.dp, start = 65.dp).fillMaxWidth()

        ) {
            Text("Buscar")
        }

        if(error) {
            Spacer(Modifier.height(20.dp))
            Error()
        }

    }

}

@Composable
fun Error() {
    Box(modifier = Modifier.background(Color(0xFFFF8B8B))) {
        Text("No se ha podido encontrar este alimento", modifier = Modifier.padding(16.dp))
    }
}