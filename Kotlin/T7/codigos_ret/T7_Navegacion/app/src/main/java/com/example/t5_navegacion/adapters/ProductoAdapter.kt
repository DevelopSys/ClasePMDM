package com.example.t5_navegacion.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.t5_navegacion.R
import com.example.t5_navegacion.model.Producto

class ProductoAdapter(var contexto: Context) : RecyclerView.Adapter<ProductoAdapter.MyHolder>() {

    var lista: ArrayList<Producto>

    init {
        lista = ArrayList();
    }

    class MyHolder(item: View) : RecyclerView.ViewHolder(item) {
        var textoPrecio: TextView = item.findViewById(R.id.textoPrecio)
        var textoTitulo: TextView = item.findViewById(R.id.textoTitulo)
        var imagen: ImageView = item.findViewById(R.id.imagenLista)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        return MyHolder(
            LayoutInflater.from(contexto).inflate(R.layout.item_recycler, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return this.lista.size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val producto = lista[position]
        holder.textoTitulo.text = producto.title
        holder.textoPrecio.text = producto.price.toString()
        Glide.with(contexto).load(producto.thumbnail).into(holder.imagen)
    }

    fun addProducto(x: Producto) {
        lista.add(x)
        notifyItemInserted(lista.size-1)
    }
}