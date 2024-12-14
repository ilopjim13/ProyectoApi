package com.example.proyectoapi.viewModel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import com.example.proyectoapi.model.Alimento
import com.example.proyectoapi.model.Usuario
import com.example.proyectoapi.navigation.InfoObj
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.net.HttpURLConnection
import java.net.URL

class ViewModel {

    val usuario = mutableStateOf(Usuario("Pepe", "123456","USER", mutableStateListOf(), mutableStateListOf()))

    private var _isFavorite = mutableStateOf(false)
    val isFavorite:State<Boolean> = _isFavorite

    private var _alimento:MutableState<InfoObj?> = mutableStateOf(null)
    val alimento:State<InfoObj?> = _alimento

    private var _error = mutableStateOf(false)
    val error:State<Boolean> = _error

    private var _isRandom = mutableStateOf(false)
    val isRandom:State<Boolean> = _isRandom

    private var _code = mutableStateOf("")
    val code:State<String> = _code

    fun onChangeCode(text:String) {
        _code.value = text
    }

    fun resetVariable() {
        _isFavorite.value = false
        _error.value = false
        _code.value = ""
        _alimento.value = null
        _isRandom.value = false
    }

    fun onClickFav(alimento: InfoObj?) {
        val check = usuario.value.favoritos.find { it.nombre == alimento?.nombre }
        if (check !in usuario.value.favoritos && alimento != null){
            alimento.isFavorite = true
            usuario.value.favoritos.add(alimento)
        }
        else if (check in usuario.value.favoritos && alimento != null){
            usuario.value.favoritos.remove(check)
        }
    }

    fun checkFav(alimento: InfoObj?):Boolean {
        val chek = usuario.value.favoritos.find { alimento?.nombre == it.nombre }
        return chek?.isFavorite == true
    }

    fun addHistorial(alimento: InfoObj) {
        if (alimento !in usuario.value.historial) usuario.value.historial.add(alimento)
    }

    fun changeIsFavorite() {
        _isFavorite.value = !_isFavorite.value
    }

    fun changeIsRandom() {
        _isRandom.value = !_isRandom.value
    }

    fun changeError(bool:Boolean) {
        _error.value = bool
    }

    fun changeAlimento(alimento: InfoObj?) {
        if (alimento != null) _alimento.value = alimento
    }

    suspend fun getAlimentoRandom():InfoObj? {
        val random = mutableListOf(
            "7622210449283",
            "3017620425035",
            "5449000214911",
            "20724696",
            "3046920022651",
            "7300400481588",
            "3046920029759",
            "3046920022606",
            "5410041001204",
            "20267605",
            "5411188112709",
            "3168930010265",
            "20022464",
            "7300400481595",
            "3033710065967",
            "5411188119098",
        ).random()

        return getAlimento(random)
    }

    suspend fun getAlimento(code:String):InfoObj? = withContext(Dispatchers.IO) {
        val url = "https://world.openfoodfacts.org/api/v0/product/$code.json"

        val connection = URL(url).openConnection() as HttpURLConnection

        return@withContext try {
            connection.requestMethod = "GET"

            val response = connection.inputStream.bufferedReader().use { it.readText() }
            val data: Map<String, Any?> = jacksonObjectMapper().readValue(response)

            if (data.containsKey("product")) {
                val product = data["product"] as Map<*, *>
                val nombre = product["product_name"]
                val marca = product["brands"]
                val etiqueta = product["labels"]
                val imageUrl = product["image_url"]
                connection.disconnect()
                InfoObj(nombre.toString(), marca.toString(), etiqueta.toString(), imageUrl.toString())
            } else {
                connection.disconnect()
                null
            }

        }catch (e: Exception) {
            e.printStackTrace()
            null
        } finally {
            connection.disconnect()
        }

    }


}