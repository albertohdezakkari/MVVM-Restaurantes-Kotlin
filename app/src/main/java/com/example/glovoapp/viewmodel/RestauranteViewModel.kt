package com.example.glovoapp.viewmodel

import android.content.Intent
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.glovoapp.R
import com.example.glovoapp.model.Restaurante
import com.example.glovoapp.model.observable.RestauranteObservable
import com.example.glovoapp.view.DetailActivity
import com.example.glovoapp.view.RecyclerRestaurantesAdapter

class RestauranteViewModel: ViewModel() {

    private var restauranteObservable: RestauranteObservable = RestauranteObservable()
    private var recyclerRestaurantesAdapter: RecyclerRestaurantesAdapter? = null
    var id_categoria = MutableLiveData<String>()

    fun callRestaurantes() {
        restauranteObservable.callRestaurantes()
    }

    fun getRestaurantes() : MutableLiveData<List<Restaurante>> {
        return restauranteObservable.getRestaurantes()
    }
/* Ayuda */
/*
    fun clickFiltroVentas(v: View) {
        callRestaurantesMasVentas()
    }
*/
/* Ayuda
    fun clickFiltroValoracion(v: View) {
        callRestaurantesMasVotos()
    }
*/
    fun clickDetail(v: View, restaurante: Restaurante) {
        var restaurante = restaurante
        val intent: Intent = Intent(v.context, DetailActivity::class.java).
        putExtra("restaurante", restaurante)
        v.context.startActivity(intent)
    }
/* Ayuda */
    fun clickVerCategorias(v: View) {
        Toast.makeText(v.context, "Ayuda filtro", Toast.LENGTH_LONG).show();
    /*val intent: Intent = Intent(v.context, CategoriasActivity::class.java)
        v.context.startActivity(intent)
        */
    }
/**/
    fun getRestauranteAt(position: Int) : Restaurante? {
        var restaurantes: List<Restaurante>? =
            restauranteObservable.getRestaurantes().value
        return restaurantes?.get(position)
    }

    fun setRestaurantesInRecyclerAdapter(restaurantes: List<Restaurante>){
        recyclerRestaurantesAdapter?.setRestaurantesList(restaurantes)
        recyclerRestaurantesAdapter?.notifyDataSetChanged()

    }

    fun getRecyclerRestaurantesAdapter(): RecyclerRestaurantesAdapter?{
        recyclerRestaurantesAdapter = RecyclerRestaurantesAdapter(this, R.layout.card_restaurante)
        return recyclerRestaurantesAdapter
    }

}