package com.example.concesionario.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.concesionario.R
import com.example.concesionario.model.Modelo

class AdapterModelo(var lista: ArrayList<Modelo>) : BaseAdapter() {
    // cuantos elementos tienes que pintar
    override fun getCount(): Int {
        return lista.size
    }

    // retorna el valor del elemento en la posicion indicada
    override fun getItem(position: Int): Modelo {
        return lista[position]
    }

    // retorna el valor del id del elemento de la posicion indicada
    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    // retrona la vista ya pintada (personalizada)
    @SuppressLint("ViewHolder")
    override fun getView(
        position: Int,
        convertView: View?,
        parent: ViewGroup?
    ): View? {
        val view =
            LayoutInflater.from(parent?.context)
                .inflate(
                    R.layout.item_spinner,
                    parent, false
                )
        // sacar cada uno de lo los elementos del XML
        val textoModelo: TextView= view.findViewById(R.id.nombreModelo)
        val imagenModelo: ImageView = view.findViewById(R.id.imagenModelo)
        val modelo: Modelo = lista[position]

        textoModelo.text = modelo.modelo
        imagenModelo.setImageResource(modelo.marca.logo)

        return view
    }
}