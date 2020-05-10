package com.example.glovoapp.model.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.glovoapp.model.Restaurante
import com.example.glovoapp.network.ApiAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RestauranteRepositoryImpl: RestauranteRepository {

    private var restaurantes = MutableLiveData<List<Restaurante>>()

    override fun getRestaurantes(): MutableLiveData<List<Restaurante>> {
        return restaurantes
    }

    override fun callRestaurantesAPI() {
        val apiAdapter = ApiAdapter()
        val apiService = apiAdapter.getClientService()
        val call = apiService.getRestaurantes()

        call.enqueue(object : Callback<ArrayList<Restaurante>> {
            override fun onFailure(call: Call<ArrayList<Restaurante>>, t: Throwable) {
                Log.e("ERROR ", t.message)
                t?.stackTrace
            }

            override fun onResponse(call: Call<ArrayList<Restaurante>>, response: Response<ArrayList<Restaurante>>) {
                val responseBody = response.body()
                restaurantes.value = responseBody
            }

        })
    }


}