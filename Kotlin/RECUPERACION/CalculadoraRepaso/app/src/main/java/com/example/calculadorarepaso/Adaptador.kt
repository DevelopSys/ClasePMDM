package com.example.calculadorarepaso

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class Adaptador: RecyclerView.Adapter<Adaptador.MyHolder>() {

    class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        // inicializar las variables de la parte grafica
        // item_recycler.xml
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        // retornar el MyHolder(con el XML inflado)
        TODO("Not yet implemented")

    }

    override fun getItemCount(): Int {
        // retornar el tamaño de la lista
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        // represnetar cada una de las filas con sus datos
        TODO("Not yet implemented")
    }
}