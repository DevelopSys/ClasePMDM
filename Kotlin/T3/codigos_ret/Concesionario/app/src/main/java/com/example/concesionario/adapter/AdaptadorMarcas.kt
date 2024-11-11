package com.example.concesionario.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.SpinnerAdapter
import android.widget.TextView
import com.example.concesionario.R
import com.example.concesionario.model.Marca

class AdaptadorMarcas(var listaMarcas: ArrayList<Marca>, var context: Context) : BaseAdapter() {
    // cuantas filas tiene que renderizar
    override fun getCount(): Int {
        return listaMarcas.size
    }

    // dame el elemento de la fila
    override fun getItem(position: Int): Marca {
        return listaMarcas[position]
    }

    // dame el id del elemento que esta en la fila
    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    // como se representa cada fila
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        // el XML Para poder poder pintarlo
        // int -> vista
        val view: View = LayoutInflater.from(context)
            .inflate(R.layout.item_marca, parent, false)
        // los elementos que vas a personalizar
        val imagen: ImageView = view.findViewById(R.id.imagenSpinnerMarca);
        val texto: TextView = view.findViewById(R.id.textoSpinnerMarca);

        // poner cada cosa en su sitio Imagen de la marca -> imagen Nombre de la marca -> texto
        val marcaPosicion = listaMarcas[position]
        texto.text = marcaPosicion.nombre
        imagen.setImageResource(marcaPosicion.imagen!!)
        return view
    }
}