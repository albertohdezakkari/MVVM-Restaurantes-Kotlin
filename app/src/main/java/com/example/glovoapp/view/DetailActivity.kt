package com.example.glovoapp.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView
import com.example.glovoapp.R
import com.example.glovoapp.model.Restaurante
import com.squareup.picasso.Picasso

class DetailActivity : AppCompatActivity() {

    var restaurante: Restaurante? = null
    var detailNombre: TextView? = null
    var detailTipo: TextView? = null
    var detailDescripcion: TextView? = null
    var detailImagen: ImageView? = null
    var detailVerComidas: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_activity)

        initComponents()
        cargarRestaurante()
    }

    private fun initComponents() {
        detailNombre = findViewById(R.id.tv_restaurante_details_name)
        detailDescripcion = findViewById(R.id.tv_restaurante_details_descripcion)
        detailTipo = findViewById(R.id.tv_restaurante_details_tipo)
        detailImagen = findViewById(R.id.iv_restaurante_details_thumb)
        detailVerComidas = findViewById(R.id.lblVerComidas)
    }

    private fun cargarRestaurante() {
        var miPantalla: Intent?= getIntent()
        restaurante = miPantalla?.getExtras()?.get("restaurante") as Restaurante?
        detailNombre?.setText(restaurante?.nombre)
        detailTipo?.setText(restaurante?.categoria)
        detailDescripcion?.setText(restaurante?.descripcion)
        Picasso.get().load("http://192.168.1.48/images/" + restaurante?.imagen).into(detailImagen)

        detailVerComidas?.setOnClickListener{
            /*val intent = Intent(this, ComidasActivity::class.java)
            intent.putExtra("id_restaurante", restaurante?.id_restaurante)
            startActivity(intent)*/
        }
        //IMAGENES
    }



}