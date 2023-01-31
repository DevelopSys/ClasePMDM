package com.develop.t6_menus.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.develop.t6_menus.R
import com.develop.t6_menus.model.Asignatura
import com.develop.t6_menus.model.Ciclo

class AdaptadorCiclos(var context: Context, var lista: ArrayList<Ciclo>) : BaseAdapter() {

    override fun getCount(): Int {
        return lista.size
    }

    override fun getItem(p0: Int): Ciclo {
        return lista[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }



    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View
    {

        val ciclo = lista[p0]
        val vista: View = LayoutInflater.from(context).inflate(R.layout.item_spinner, p2, false)
        var textNombre: TextView = vista.findViewById(R.id.nombre_spinner);
        var imagenImage: ImageView = vista.findViewById(R.id.imagen_spinner);

        textNombre.setText(ciclo.nombre)
        imagenImage.setImageResource(ciclo.imagen)

        return vista
    }
}