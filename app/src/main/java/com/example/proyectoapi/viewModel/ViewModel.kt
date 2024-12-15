package com.example.proyectoapi.viewModel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import com.example.proyectoapi.model.Usuario
import com.example.proyectoapi.navigation.InfoObj

class ViewModel {

    val usuario = mutableStateOf(Usuario("Pepe", "1234","USER", mutableStateListOf(), mutableStateListOf()))

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

    fun changeIsRandom(bool: Boolean) {
        _isRandom.value = bool
    }

    fun changeError(bool:Boolean) {
        _error.value = bool
    }

    fun changeAlimento(alimento: InfoObj?) {
        if (alimento != null) _alimento.value = alimento
    }

}