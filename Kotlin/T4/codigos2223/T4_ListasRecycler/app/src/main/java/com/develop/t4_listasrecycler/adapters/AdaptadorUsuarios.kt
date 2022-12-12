package com.develop.t4_listasrecycler.adapters

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.develop.t4_listasrecycler.model.Usuario

class AdaptadorUsuarios(var lista: ArrayList<Usuario>, var contexto: Context)
    : RecyclerView.Adapter<AdaptadorUsuarios.MyHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        var vista: View = ; // xml aspecto de cada fila
        return MyHolder(vista);
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
    }

    override fun getItemCount(): Int {
        // tamaño de la lista
        return lista.size
    }

    inner class MyHolder(itemView: View) : ViewHolder(itemView) {

    }
}