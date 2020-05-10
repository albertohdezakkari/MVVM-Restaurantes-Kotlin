package com.example.glovoapp.model

import android.util.Log
import com.google.gson.JsonObject
import java.io.Serializable

class Restaurante (restauranteJson: JsonObject?) : Serializable {
    var id_restaurante = 0
    var nombre: String? = null
    var descripcion: String? = null
    var imagen: String? = null
    var ventas = 0
    var valoracion = 0.0
    var categoria: String? = null

    init {
        try {
            id_restaurante = restauranteJson!!.get("id_pelicula").asInt
            nombre = restauranteJson!!.get("nombre").asString
            descripcion = restauranteJson!!.get("descripcion").asString
            imagen = restauranteJson!!.get("imagen").asString
            ventas = restauranteJson!!.get("ventas").asInt
            valoracion = restauranteJson!!.get("valoracion").asDouble
            categoria = restauranteJson!!.get("categoria").asString
        }catch (e: Exception){
            e.printStackTrace()
        }
    }
}