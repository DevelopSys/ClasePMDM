package com.example.iniciofg.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import com.bumptech.glide.Glide
import com.example.iniciofg.R
import com.example.iniciofg.model.Producto

class AdapterProducto(var lista: ArrayList<Producto>, var contexto: Context) :
    RecyclerView.Adapter<AdapterProducto.MyHolder>() {

    inner class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imagen: ImageView = itemView.findViewById(R.id.imagenProducto)
        val boton: Button = itemView.findViewById(R.id.btnFav)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val vista: View = LayoutInflater.from(contexto).inflate(R.layout.item_recycler,parent,false)
        return MyHolder(vista)
    }

    override fun getItemCount(): Int {
        return lista.size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val producto = lista[position]
        Glide.with(contexto).load(producto.thumbnail).into(holder.imagen)
    }


    fun addProducto(x: Producto) {
        this.lista.add(x)
        notifyItemInserted(lista.size-1)
    }
}