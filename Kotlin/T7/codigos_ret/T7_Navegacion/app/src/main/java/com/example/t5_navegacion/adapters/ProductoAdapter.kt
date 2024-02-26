package com.example.t5_navegacion.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.t5_navegacion.R
import com.example.t5_navegacion.model.Producto
import com.google.firebase.database.FirebaseDatabase

class ProductoAdapter(var contexto: Context, var uid: String) :
    RecyclerView.Adapter<ProductoAdapter.MyHolder>() {

    var lista: ArrayList<Producto>
    var database: FirebaseDatabase
    lateinit var listener: OnFavoritosListener;

    init {
        listener = contexto as OnFavoritosListener
        lista = ArrayList();
        database =
            FirebaseDatabase.getInstance("https://proyectoret-bmh2023-default-rtdb.firebaseio.com/");
    }

    class MyHolder(item: View) : RecyclerView.ViewHolder(item) {
        var toolbar: Toolbar = item.findViewById(R.id.toolbarProducto)
        var textoPrecio: TextView = item.findViewById(R.id.textoPrecio)
        var imagen: ImageView = item.findViewById(R.id.imagenLista)

        init {
            toolbar.inflateMenu(R.menu.menu_producto)
        }
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
        holder.toolbar.title = producto.title
        holder.textoPrecio.text = producto.price.toString()
        Glide.with(contexto).load(producto.thumbnail).into(holder.imagen)
        holder.toolbar.setOnMenuItemClickListener {

            when (it.itemId) {
                R.id.menu_fav_producto -> {
                    database.getReference("usuarios").child(uid)
                        .child("favoritos").child(producto.id.toString()).setValue(producto)
                }

                R.id.menu_fav -> {
                    // interfaz -> MainActivity
                    listener.onFavoritoSelected()
                }
                R.id.menu_fav_eliminar -> {
                    // interfaz -> MainActivity

                }
            }

            return@setOnMenuItemClickListener true
        }
    }

    fun addProducto(x: Producto) {
        lista.add(x)
        notifyItemInserted(lista.size - 1)
    }

    interface OnFavoritosListener{
        fun onFavoritoSelected()
    }
}