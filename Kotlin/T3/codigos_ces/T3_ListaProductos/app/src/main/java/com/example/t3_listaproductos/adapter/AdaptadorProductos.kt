package com.example.t3_listaproductos.adapter

import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.t3_listaproductos.R
import com.example.t3_listaproductos.model.Producto

class AdaptadorProductos
    (var lista: ArrayList<Producto>)
    : RecyclerView.Adapter<AdaptadorProductos.MyHolder>() {

    class MyHolder(item: View): ViewHolder(item){
        var carta: CardView
        var textoNombre: TextView
        var viewImagen: ImageView

        init {
            carta = item.findViewById(R.id.carta)
            textoNombre = item.findViewById(R.id.nombre_producto)
            viewImagen = item.findViewById(R.id.imagen_producto)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        
    }

    override fun getItemCount(): Int {
        return  lista.size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        TODO("Not yet implemented")
    }
}