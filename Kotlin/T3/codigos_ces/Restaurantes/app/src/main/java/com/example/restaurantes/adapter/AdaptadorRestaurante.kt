package com.example.restaurantes.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.restaurantes.R
import com.example.restaurantes.model.Restaurante

class AdaptadorRestaurante(var lista: ArrayList<Restaurante>, var context: Context) :
    BaseAdapter() {
    override fun getCount(): Int {
        return lista.size
    }

    override fun getItem(p0: Int): Restaurante {
        return lista[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {

        val vista: View = LayoutInflater.from(context).inflate(R.layout.item_restaurante, p2, false)
        val imagen: ImageView = vista.findViewById(R.id.imagenRestaurante)
        val nombre: TextView = vista.findViewById(R.id.textoRestaurante)
        val restaurante = lista[p0]

        // https://cdn-icons-png.flaticon.com/512/4474/4474826.png
        // https://static.thenounproject.com/png/3594675-200.png
        // https://cdn-icons-png.flaticon.com/512/678/678872.png
        var url: String = ""
        nombre.text = restaurante.nombre
        when (restaurante.comida) {
            "chino" -> {
                url = "https://cdn-icons-png.flaticon.com/512/678/678872.png"
            }

            "mediterraneo" -> {
                url = "https://static.thenounproject.com/png/3594675-200.png"
            }

            "japones" -> {
                url = "https://cdn-icons-png.flaticon.com/512/4474/4474826.png"
            }
        }
        Glide.with(context).load(url).placeholder(R.drawable.restaurante).into(imagen);

        return vista
    }
}