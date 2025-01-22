package com.example.repaso.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.repaso.R
import com.example.repaso.model.Pregunta

class AdapterTrivial(val contexto: Context) : RecyclerView.Adapter<AdapterTrivial.MyHolder>() {

    private lateinit var lista: ArrayList<Pregunta>

    init {
        lista = ArrayList()
    }

    class MyHolder(itemView: View) : ViewHolder(itemView) {
        // los elementos que tiene cada XML
        val textoPregunta: TextView = itemView.findViewById(R.id.titleQuestion)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val vista = LayoutInflater.from(contexto).inflate(R.layout.item_recycler, parent,
            false)
        return MyHolder(vista)
    }

    override fun getItemCount(): Int {
        return lista.size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val pregunta = lista[position]
        holder.textoPregunta.text = pregunta.question
    }

    fun agregarPregunta(x: Pregunta) {
        lista.add(x)
        //notifyItemInserted(lista.size-1)
        notifyDataSetChanged()
    }
}