package com.example.glovoapp.model.repository

import androidx.lifecycle.MutableLiveData
import com.example.glovoapp.model.Restaurante

interface RestauranteRepository {
    fun getRestaurantes(): MutableLiveData<List<Restaurante>>

    fun callRestaurantesAPI()

   /* fun callRestaurantesMasVentas()
    fun callRestaurantesMasValorados()
    fun callRestaurantesByTipo(id_categoria: Int)
    */
}
