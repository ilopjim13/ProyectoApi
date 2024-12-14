package com.example.proyectoapi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.proyectoapi.appBar.BottomBar
import com.example.proyectoapi.appBar.MyTopAppBar
import com.example.proyectoapi.navigation.InfoObj
import com.example.proyectoapi.navigation.Proyecto
import com.example.proyectoapi.ui.theme.ProyectoApiTheme
import com.example.proyectoapi.viewModel.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    //val alimentosImages = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProyectoApiTheme {
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


//    fun getRetrofit():Retrofit = Retrofit.Builder().baseUrl("https://dog.ceo/api/breed").addConverterFactory(GsonConverterFactory.create()).build()

//    fun serachByName(query:String) {
//        CoroutineScope(Dispatchers.IO).launch {
//            val call = getRetrofit().create(ApiService::class.java).getAlimentoByAllergies("$query/images")
//            val alimentos = call.body()
//            if (call.isSuccessful) {
//                val images = alimentos?.images ?: emptyList()
//                alimentosImages.clear()
//                alimentosImages.addAll(images)
//            } else {
//                showError()
//            }
//        }
//    }

//    fun showError() {
//        Toast.makeText(this, "Ha ocurrido un error", Toast.LENGTH_SHORT).show()
//    }



}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ProyectoApiTheme {
        Greeting("Android")
    }
}