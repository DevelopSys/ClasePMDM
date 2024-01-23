package com.example.t5_fragments.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.t5_fragments.R

class AdaptadorImagenes(var contexto: Context, var imagenes: ArrayList<String>) :
    RecyclerView.Adapter<AdaptadorImagenes.MyHolder>() {

    class MyHolder(itemView: View) : ViewHolder(itemView) {
        val imagen: ImageView = itemView.findViewById(R.id.imagen_carrusel)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        return MyHolder(LayoutInflater.from(contexto).inflate(R.layout.item_imagen, parent, false))
    }

    override fun getItemCount(): Int {
        return imagenes.size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val item = imagenes[position]
        Glide.with(contexto).load(item).into(holder.imagen)
    }

}