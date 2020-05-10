package com.example.glovoapp.model.observable

import androidx.databinding.BaseObservable
import androidx.lifecycle.MutableLiveData
import com.example.glovoapp.model.Restaurante
import com.example.glovoapp.model.repository.RestauranteRepository
import com.example.glovoapp.model.repository.RestauranteRepositoryImpl

class RestauranteObservable: BaseObservable() {

    private var restauranteRepository: RestauranteRepository = RestauranteRepositoryImpl()

    fun callRestaurantes() {
        restauranteRepository.callRestaurantesAPI()
    }

    fun getRestaurantes() : MutableLiveData<List<Restaurante>>{
        return restauranteRepository.getRestaurantes()
    }
/*Ayuda*/
/*
    fun callRestaurantesByTipo(id_categoria : Int) {
        restauranteRepository.callRestaurantesByTipo(id_categoria)
    }
*/
/*Ayuda*/
/*
    fun callRestaurantesMasVentas() {
        restauranteRepository.callRestaurantesMasVentas()
    }
*/
/*Ayuda*/
/*

    fun callRestauranteMejorValorados() {
        restauranteRepository.callRestaurantesMasValorados()
    }
*/
}