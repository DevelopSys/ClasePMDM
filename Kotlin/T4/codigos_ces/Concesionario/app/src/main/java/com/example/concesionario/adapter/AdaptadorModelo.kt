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
import com.example.concesionario.model.Modelo

class AdaptadorModelo(var lista: ArrayList<Modelo>, var context: Context) : BaseAdapter() {
    override fun getCount(): Int {
        // el numero de filas
        return lista.size
    }

    override fun getItem(p0: Int): Modelo {
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
        val view: View = LayoutInflater.from(context).inflate(R.layout.item_modelo,
            p2, false)
        val modeloActual = lista[p0]
        val imagen: ImageView = view.findViewById(R.id.imagenModelo)
        val nombre: TextView = view.findViewById(R.id.nombreModelo)
        imagen.setImageResource(modeloActual.imagen)
        nombre.text = modeloActual.modelo
        return view;
    }

    fun cambiarLista(listaNueva: ArrayList<Modelo>){
        this.lista = listaNueva
        notifyDataSetChanged()
    }
}