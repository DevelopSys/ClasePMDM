package com.example.tienda.adapters

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.tienda.R
import com.example.tienda.model.Producto
import com.example.tienda.ui.DetaiActivity
import com.google.android.material.snackbar.Snackbar

class AdaptadorProductos(
    var lista: ArrayList<Producto>, var context: Context, var funcion: ((Double) -> Unit)? = null
) :
    RecyclerView.Adapter<AdaptadorProductos.MyHolder>() {
    private lateinit var listener: OnProductoListener

    init {
        listener = context as OnProductoListener
    }

    class MyHolder(item: View, adaptadorProductos: AdaptadorProductos) : ViewHolder(item) {

        // cualquier evento asociado a una posicion -> AQUI

        var imagen: ImageView = item.findViewById(R.id.imagenProducto)
        var toolbar: Toolbar = item.findViewById(R.id.toolbar)

        init {
            toolbar.inflateMenu(R.menu.menu_card)
            imagen.setOnLongClickListener {
                adaptadorProductos.removeItem(adapterPosition)
                return@setOnLongClickListener true
            }
        }
    }

    fun removeItem(position: Int) {
        lista.removeAt(position)
        notifyItemRemoved(position)
    }

    override fun getItemCount(): Int {
        return lista.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val view = LayoutInflater.from(context).inflate(
            R.layout.ite_recycler,
            parent, false
        )
        val holder: MyHolder = MyHolder(view, this);
        return holder;
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val producto: Producto = lista[position]

        // https://cdn-icons-png.freepik.com/512/925/925072.png ropa
        // https://cdn-icons-png.freepik.com/256/3206/3206042.png?semt=ais_hybrid tecno
        // https://cdn-icons-png.flaticon.com/512/3248/3248597.png jardin
        var imagen: String = ""
        holder.toolbar.title = producto.nombre
        holder.toolbar.setOnMenuItemClickListener {
            // evaluar quien es el pulsado
            when (it.itemId) {
                R.id.menuCardComparar -> {
                    listener.onProductoSelected(producto)
                }
                R.id.menuCardDetalle -> {
                    val intent = Intent(context, DetaiActivity::class.java)
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                    val bundle = Bundle()
                    bundle.putSerializable("producto",producto)
                    intent.putExtra("datos",bundle)
                    context.startActivity(intent)
                }
            }
            return@setOnMenuItemClickListener true
        }
        when (producto.categoria) {
            "ropa" -> imagen = "https://cdn-icons-png.freepik.com/512/925/925072.png"
            "tecnologia" -> imagen =
                "https://cdn-icons-png.freepik.com/256/3206/3206042.png?semt=ais_hybrid"

            "jardin" -> imagen = "https://cdn-icons-png.flaticon.com/512/3248/3248597.png"
        }
        Glide.with(context).load(imagen).placeholder(R.drawable.images).into(holder.imagen)
        /*holder.boton.setOnClickListener {
            *//*Snackbar.make(holder.boton, "Boton pulsado desde el adaptador ${producto.precio}", Snackbar.LENGTH_SHORT)
                .show()*//*
            *//*val intent: Intent = Intent(context, DetaiActivity::class.java)
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(intent)*//*
            listener.onProductoSelected(producto)
        }*/
        holder.imagen.setOnClickListener {
            funcion?.invoke(producto.precio)
        }

    }

    interface OnProductoListener {
        fun onProductoSelected(producto: Producto)
    }

}