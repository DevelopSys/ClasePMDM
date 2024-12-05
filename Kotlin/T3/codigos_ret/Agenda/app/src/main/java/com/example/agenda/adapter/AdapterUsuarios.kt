package com.example.agenda.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.agenda.R
import com.example.agenda.model.Usuario

class AdapterUsuarios(var context: Context) :
    Adapter<AdapterUsuarios.MyHolder>() {

    val lista: ArrayList<Usuario> = ArrayList()

    inner class MyHolder(item: View) : ViewHolder(item) {
        val toolbar: Toolbar = item.findViewById(R.id.toolbarContacto)
        val imagen: ImageView = item.findViewById(R.id.imagenContacto)
    }

    fun addUser(usuario: Usuario) {
        lista.add(usuario)
        notifyItemInserted(lista.size - 1)
    }

    override fun getItemCount(): Int {
        return lista.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val vista = LayoutInflater.from(context).inflate(R.layout.item_recycler, parent, false)
        return MyHolder(vista);
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val usuario = lista[position]
        Glide.with(context).load(usuario.image).into(holder.imagen)
        holder.toolbar.setTitle("${usuario.firstName} ${usuario.lastName}")
        holder.toolbar.inflateMenu(R.menu.meni_item)
        holder.toolbar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.menuDetalles -> {
                    // comunica el id para pasar de pantalla
                }

                R.id.menuComparar -> {
                    // comunica el objeto para comparar dos elementos cuando esten disponibles
                }
            }
            return@setOnMenuItemClickListener true
        }
    }

}
