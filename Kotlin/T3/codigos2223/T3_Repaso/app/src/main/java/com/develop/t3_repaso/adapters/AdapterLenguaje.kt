package com.develop.t3_repaso.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.develop.t3_repaso.R
import com.develop.t3_repaso.model.Lenguaje

class AdapterLenguaje(var lista: ArrayList<Lenguaje>,var context: Context ): BaseAdapter() {
    override fun getCount(): Int {
        return lista.size
    }

    override fun getItem(p0: Int): Lenguaje {
        return lista.get(p0)
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {

        var view: View = LayoutInflater.from(context).inflate(R.layout.item_spinner,p2,false)

        var imagen: ImageView = view.findViewById(R.id.imagen_fila);
        var nombre: TextView = view.findViewById(R.id.nombre_fila);

        var lenguaje = lista.get(p0);

        imagen.setImageResource(lenguaje.imagen)
        nombre.setText(lenguaje.nombre)

        return view;
    }
}