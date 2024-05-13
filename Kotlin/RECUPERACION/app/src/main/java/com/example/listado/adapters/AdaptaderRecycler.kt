package com.example.listado.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.listado.R

class AdaptaderRecycler(var listaDatos: ArrayList<String>, var context: Context) :
    RecyclerView.Adapter<AdaptaderRecycler.MyHolder>() {

    class MyHolder(item: View) : ViewHolder(item) {
        val textoFila: TextView = item.findViewById(R.id.textoFila)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val vista: View = LayoutInflater.from(context).inflate(
            R.layout.fila_recycler,
            parent, false
        );
        return MyHolder(vista)
    }

    override fun getItemCount(): Int {
        return listaDatos.size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val elemento = listaDatos[position]
        holder.textoFila.text = elemento;
    }

}