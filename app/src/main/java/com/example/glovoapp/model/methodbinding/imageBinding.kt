package com.example.glovoapp.model.methodbinding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso

class imageBinding {

    constructor()

    companion object {
        @BindingAdapter("imagen")
        @JvmStatic
        fun setImagenUrl(imageView: ImageView, imageUrl: String?) {
            Picasso.get().load("http://172.17.87.241:8050/api/images/$imageUrl")
                .into(imageView)
            //http://192.168.38.33:8010/images/100m.png

        }
    }
}