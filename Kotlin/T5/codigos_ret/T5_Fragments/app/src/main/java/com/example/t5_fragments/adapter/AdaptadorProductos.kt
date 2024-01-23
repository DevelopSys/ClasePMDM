package com.example.t5_fragments.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.t5_fragments.R
import com.example.t5_fragments.model.Producto


class AdaptadorProductos(var contexto: Context) :
    RecyclerView.Adapter<AdaptadorProductos.MyHolder>() {

    private lateinit var listaProductos: ArrayList<Producto>
    private lateinit var listener: OnProductoListener

    init {
        listaProductos = ArrayList()
        listener = contexto as OnProductoListener
    }

    class MyHolder(itemView: View) : ViewHolder(itemView) {
        var textoProducto: TextView = itemView.findViewById(R.id.nombre_fila);
        var imagenProducto: ImageView = itemView.findViewById(R.id.imagen_fila)
        var carta: CardView = itemView.findViewById(R.id.carta_fila)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        return MyHolder(
            LayoutInflater.from(contexto).inflate(
                R.layout.item_card,
                parent, false
            )
        )
    }

    override fun getItemCount(): Int {
        return listaProductos.size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val item = listaProductos[position]
        holder.textoProducto.text = item.nombre
        //holder.imagenProducto.setImageResource(R.drawable.producto)
        Glide.with(contexto).load(item.imagen).into(holder.imagenProducto)
        holder.carta.setOnClickListener {
            // pasar al siguiente fragment
            listener.onProductoSelected(item)
        }
    }

    fun agregarProducto(x: Producto) {
        listaProductos.add(x)
        notifyItemInserted(listaProductos.size-1)
    }

    interface OnProductoListener{
        fun onProductoSelected(x: Producto)
    }
}