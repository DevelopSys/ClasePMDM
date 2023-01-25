package com.develop.t6_menus_ret

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdaptadorAsignaturas(var listaDatos: ArrayList<String>, var context: Context): RecyclerView.Adapter<AdaptadorAsignaturas.MyHolder>(){

    inner class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textoNombre: TextView

        init {
            textoNombre = itemView.findViewById(R.id.texto_item)
        }
    }

    fun agregarDato(nombre: String){
        listaDatos.add(nombre)
        notifyItemInserted(listaDatos.size-1)
    }

    fun vaciarLista(){
        listaDatos.clear()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val vista = LayoutInflater.from(context).inflate(R.layout.item_recycler,parent,false)
        return MyHolder(vista)
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val nombre = listaDatos[position]

        holder.textoNombre.text = nombre
        holder.textoNombre.setOnLongClickListener {
            listaDatos.remove(nombre)
            this.notifyItemRemoved(position)
            return@setOnLongClickListener true
        }
    }

    override fun getItemCount(): Int {
        return listaDatos.size
    }

}