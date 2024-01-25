package com.example.t5_navegacion.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.t5_navegacion.R
import com.example.t5_navegacion.model.Producto
import com.google.firebase.database.FirebaseDatabase

class AdapterProductos(var context: Context, var uid: String) :
    RecyclerView.Adapter<AdapterProductos.MyHolder>() {
    private var listaProductos: ArrayList<Producto>;
    val bdb: FirebaseDatabase = FirebaseDatabase.getInstance("https://bmh-ces-default-rtdb.europe-west1.firebasedatabase.app/")

    // AL PULSAR EL ADD FAV SE AÑADE EL PRODUCTO AL NODO FAV DEL USUARIO LOGEADO
    // UID

    init {
        listaProductos = ArrayList()
    }

    class MyHolder(item: View) : RecyclerView.ViewHolder(item) {

        var toolbar: Toolbar
        var imagen: ImageView

        init {
            toolbar = item.findViewById(R.id.toolbar_carta)
            imagen = item.findViewById(R.id.imagen_producto)
            toolbar.inflateMenu(R.menu.item_menu)

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {

        val vista: View =
            LayoutInflater.from(context).inflate(R.layout.item_producto, parent, false)
        return MyHolder(vista);

    }

    override fun getItemCount(): Int {
        return this.listaProductos.size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val item: Producto = listaProductos[position]
        holder.toolbar.title = item.nombre
        holder.toolbar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.menu_fav_item -> {
                    val db =
                        FirebaseDatabase.getInstance("https://bmh-ces-default-rtdb.europe-west1.firebasedatabase.app/")
                    val referencia = db.getReference("usuarios").child(uid).child("fav")
                    referencia.child(item.id.toString()).setValue(item)
                }
            }
            return@setOnMenuItemClickListener true
        }
        Glide.with(context).load(item.imagen).into(holder.imagen)

    }


    fun addProducto(item: Producto) {
        listaProductos.add(item)
        notifyItemInserted(listaProductos.size - 1)
    }

}