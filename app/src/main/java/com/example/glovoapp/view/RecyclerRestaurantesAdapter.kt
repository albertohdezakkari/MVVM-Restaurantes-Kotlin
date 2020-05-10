package com.example.glovoapp.view

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.glovoapp.BR
import com.example.glovoapp.R
import com.example.glovoapp.model.Restaurante
import com.example.glovoapp.viewmodel.RestauranteViewModel
import com.squareup.picasso.Picasso

class RecyclerRestaurantesAdapter(var restauranteViewModel: RestauranteViewModel, var resource: Int) : androidx.recyclerview.widget.RecyclerView.Adapter<RecyclerRestaurantesAdapter.CardRestauranteHolder>(){
    var restaurantes: List<Restaurante>? = null


    fun setRestaurantesList(restaurantes: List<Restaurante>) {
        this.restaurantes = restaurantes
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int) : CardRestauranteHolder {
        var layoutInflater: LayoutInflater = LayoutInflater.from(p0.context)
        var binding: ViewDataBinding = DataBindingUtil.inflate(layoutInflater, p1, p0, false)
        return CardRestauranteHolder(binding)
    }

    override fun getItemCount(): Int {
        return restaurantes?.size ?: 0
    }

    override fun onBindViewHolder(p0: CardRestauranteHolder, p1: Int) {
        p0.setDataCard(restauranteViewModel, p1)
    }

    override fun getItemViewType(position: Int): Int {
        return getLayoutIdForPosition(position)
    }

    fun getLayoutIdForPosition(position: Int): Int{
        return resource
    }


    class CardRestauranteHolder(binding: ViewDataBinding) :
        RecyclerView.ViewHolder(binding.root) {

        private var binding: ViewDataBinding? = null

        var imagen: ImageView? = null
        var urlImagen: String? = null

        init {
            this.binding = binding
            imagen = binding.root.findViewById(R.id.iv_restaurante_thumb)
        }

        fun setDataCard(restauranteViewModel: RestauranteViewModel, position: Int){
            binding?.setVariable(BR.model, restauranteViewModel)
            binding?.setVariable(BR.position, position)
            binding?.executePendingBindings()

            urlImagen = restauranteViewModel.getRestauranteAt(position)?.imagen;

            Picasso.get().load("http://172.17.87.241:8050/images/" + urlImagen).into(imagen)
        }
    }
}



