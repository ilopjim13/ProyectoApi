package com.example.proyectoapi.service

import com.example.proyectoapi.navigation.InfoObj
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.net.HttpURLConnection
import java.net.URL

object ApiService {

    suspend fun getAlimentoRandom(): InfoObj? {
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

    suspend fun getAlimento(code:String): InfoObj? = withContext(Dispatchers.IO) {
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