package com.example.concesionario.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.concesionario.R
import com.example.concesionario.model.Marca

class AdaptadorMarca(var lista: ArrayList<Marca>, var context: Context) : BaseAdapter() {
    override fun getCount(): Int {
        // el numero de filas
        return lista.size
    }

    override fun getItem(p0: Int): Marca {
        // marca en la posicion p0
        return lista[p0]
    }

    override fun getItemId(p0: Int): Long {
        // el id del elemento en la posicin p0
        return p0.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        // la vista construida de cada fila
        // necesito el XML
        // R.layout.item_marca -> View
        val view: View = LayoutInflater.from(context).inflate(R.layout.item_marca,
            p2, false)
        val marcaActual = lista[p0]
        val imagen: ImageView = view.findViewById(R.id.imagenSpinner)
        val nombre: TextView = view.findViewById(R.id.textoSpinner)
        imagen.setImageResource(marcaActual.imagen)
        nombre.text = marcaActual.nombre
        return view;
    }
}