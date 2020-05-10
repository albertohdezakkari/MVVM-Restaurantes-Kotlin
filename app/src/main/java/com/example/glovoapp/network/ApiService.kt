package com.example.glovoapp.network


import com.example.glovoapp.model.Restaurante
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import java.util.*
import kotlin.collections.ArrayList

interface ApiService {

    @GET("restaurante/")
    fun getRestaurantes(): Call<ArrayList<Restaurante>>
/*Ayuda*/
/*
    @GET("restaurante/restaurantesMasVentas")
    fun getRestaurantesMasVentas(): Call<ArrayList<Restaurante>>

    /*Ayuda*/
 */
/*Ayuda*/
/*

    @GET("restaurante/restaurantesMejorValorados")
    fun getRestaurantesMejorValorados(): Call<ArrayList<Restaurante>>
*/
/*Ayuda*/
/*

    @POST("restaurante/getRestauranteByTipo/{id_categoria")
    fun getRestaurantesByTipo(@Path("id_categoria") id_categoria: Int): Call<ArrayList<Restaurante>>
*/

}