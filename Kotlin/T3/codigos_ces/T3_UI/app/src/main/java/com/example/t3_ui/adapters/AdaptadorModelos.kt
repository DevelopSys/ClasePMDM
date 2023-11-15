package com.example.t3_ui.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.example.t3_ui.R
import com.example.t3_ui.model.Modelo

class AdaptadorModelos(var listaModelos: ArrayList<Modelo>, var contexto: Context): BaseAdapter() {

    // cuantos elementos tiene el elemento grafico (spinner)
    override fun getCount(): Int {
        return listaModelos.size
    }

    // el elemento que esta en el spinner en una posicion concreta (position)
    override fun getItem(position: Int): Modelo {
        return listaModelos[position]
    }

    // el id del elemento seleccionado en el spinner en una posicion (position)
    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    fun addModelo(modelo: Modelo) {
        listaModelos.clear()
        listaModelos.add(modelo)
        notifyDataSetChanged()
    }

    fun setLista(lista: ArrayList<Modelo>) {
        listaModelos.clear()
        listaModelos.addAll(lista)
        notifyDataSetChanged()
    }

    // rellenar la fila con los datos que le corresponden
    override fun getView(position: Int, convertView: View?,
                         parent: ViewGroup?): View {

        // XML -> layout --> id (elementos)
        // Objeto de la posicion
        val vista: View = LayoutInflater.from(contexto).inflate(R.layout.item_modelo,parent,
            false);

        val modelo = listaModelos[position]

        val imageView: ImageView = vista.findViewById(R.id.imagen_modelo)
        val nombreText: TextView = vista.findViewById(R.id.nombre_modelo)

        imageView.setImageResource(modelo.imagen)
        nombreText.text = modelo.nombre


        return vista



    }
}