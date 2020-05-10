package com.example.glovoapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.glovoapp.viewmodel.RestauranteViewModel
import com.example.glovoapp.R
import com.example.glovoapp.databinding.ActivityMainBinding
import com.example.glovoapp.model.Restaurante

class MainActivity : AppCompatActivity() {

    private var restuaranteViewModel: RestauranteViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupBindings(savedInstanceState)
    }

    fun setupBindings(savedInstanceState: Bundle?) {
        var activityMainBinding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        restuaranteViewModel = ViewModelProviders.of(this).get(RestauranteViewModel::class.java)

        activityMainBinding.model = restuaranteViewModel

        setupListUpdate()
    }

    fun setupListUpdate() {
        restuaranteViewModel?.callRestaurantes()

        restuaranteViewModel?.getRestaurantes()?.observe(this, Observer {restaurantes: List<Restaurante> ->
            Log.w("Restaurante", restaurantes.get(1).ventas.toString())
            restuaranteViewModel?.setRestaurantesInRecyclerAdapter(restaurantes)
        })

    }
}
