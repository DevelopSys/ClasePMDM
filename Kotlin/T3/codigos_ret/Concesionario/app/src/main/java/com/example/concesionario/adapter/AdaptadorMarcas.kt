package com.example.concesionario.adapter

import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.SpinnerAdapter
import com.example.concesionario.model.Marca

class AdaptadorMarcas : BaseAdapter(){
    // cuantas filas tiene que renderizar
    override fun getCount(): Int {

    }

    // dame el elemento de la fila
    override fun getItem(position: Int): Marca {

    }

    // dame el id del elemento que esta en la fila
    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

        // como se representa cada fila
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        // el XML Para poder poder pintarlo

    }
}