package com.example.t3_listaproductos.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.t3_listaproductos.R
import com.example.t3_listaproductos.model.Producto

class AdaptadorProductos
    (var lista: ArrayList<Producto>, var contexto: Context)
    : RecyclerView.Adapter<AdaptadorProductos.MyHolder>() {

    lateinit var listener: OnRecyclerProductosListener

    init {
        listener = contexto as OnRecyclerProductosListener
    }

    class MyHolder(item: View): ViewHolder(item){
        var carta: CardView
        var textoNombre: TextView
        var viewImagen: ImageView
        var boton: ImageButton

        init {
            carta = item.findViewById(R.id.carta)
            textoNombre = item.findViewById(R.id.nombre_producto)
            viewImagen = item.findViewById(R.id.imagen_producto)
            boton = item.findViewById(R.id.boton_comprar)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val vista = LayoutInflater.from(parent.context).inflate(R.layout.item_recycler,
            parent, false)
        return MyHolder(vista)
    }

    override fun getItemCount(): Int {
        return  lista.size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {

        val item = lista[position]
        holder.textoNombre.text = item.nombre
        Glide.with(contexto).load(item.imagen)
            .placeholder(R.drawable.generica).into(holder.viewImagen)
        holder.boton.setOnClickListener {
            // procedo a la compra
            listener.onProductoSelected(item)
        }
        //holder.viewImagen.setImageResource(item.imagen)

    }

    fun addProducto(item: Producto) {
        lista.add(item)
        notifyItemInserted(lista.size-1);
    }

    interface OnRecyclerProductosListener{
        fun onProductoSelected(item: Producto)
    }
}