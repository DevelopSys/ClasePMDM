package com.example.tienda.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.tienda.R
import com.example.tienda.model.Producto
import com.squareup.picasso.Picasso

class ProductoAdapter(val lista: List<Producto>,
                      val context: Context,
                      var funcion: ((Int, Producto)->Unit)? = null) :
    RecyclerView.Adapter<ProductoAdapter.MyHolder>() {
    private var listener: OnProductoListener

    init {
        listener = context as OnProductoListener
    }


    // Holder -> plantilla -> comun para todas las filas
    inner class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imagen: ImageView = itemView.findViewById(R.id.imagenProducto)
        val nombre: TextView = itemView.findViewById(R.id.nombreProducto)
        val boton: Button = itemView.findViewById(R.id.btnComparar)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_producto, parent, false);
        return MyHolder(view)
    }

    override fun getItemCount(): Int {
        return lista.size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val producto = lista[position]
        // holder.imagen.setImageResource(R.drawable.producto)
        holder.nombre.text = producto.nombre


        var url: String = ""
        when (producto.categoria) {
            "ropa" -> {
                url = "https://cdn-icons-png.freepik.com/256/545/545485.png?semt=ais_hybrid"
            }

            "tecnologia" -> {
                url = "https://cdn-icons-png.flaticon.com/512/10755/10755374.png"
            }

            "mueble" -> {
                url = "https://cdn-icons-png.flaticon.com/512/1198/1198317.png"
            }
        }
        Glide.with(context).load(url)
            .placeholder(R.drawable.producto)
            .into(holder.imagen)

        holder.imagen.setOnLongClickListener {
            Log.v("pulsacion", "Pulsado elemento")
            // notifyDataSetChanged()

            // (lista as ArrayList).removeAt(position)
            notifyItemRemoved(position)
            return@setOnLongClickListener true
        }
        holder.boton.setOnClickListener {
            listener.onProductoSelected(producto)
            // funcion?.invoke(position, producto)
        }
    }


    interface OnProductoListener {
        fun onProductoSelected(producto: Producto)
    }


}
