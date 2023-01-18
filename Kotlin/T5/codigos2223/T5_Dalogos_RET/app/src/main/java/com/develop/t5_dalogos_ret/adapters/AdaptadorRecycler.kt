package com.develop.t5_dalogos_ret.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.develop.t5_dalogos_ret.R
import com.develop.t5_dalogos_ret.model.Usuario

class AdaptadorRecycler(var contexto: Context, var lista: ArrayList<Usuario>) :
    RecyclerView.Adapter<AdaptadorRecycler.MyHolder>() {

    inner class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var textoNombre: TextView
        var textoDept: TextView


        init {
            textoNombre = itemView.findViewById(R.id.item_nombre)
            textoDept = itemView.findViewById(R.id.item_departamento)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val vista: View = LayoutInflater.from(contexto)
            .inflate(R.layout.item_recycler,parent,false)
        return  MyHolder()
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        return lista.size
    }

}