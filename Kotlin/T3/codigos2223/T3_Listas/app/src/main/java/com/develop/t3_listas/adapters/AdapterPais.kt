package com.develop.t3_listas.adapters

import android.content.Context
import android.view.ContextMenu
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.develop.t3_listas.R
import com.develop.t3_spinner.modelo.Pais

class AdapterPais(
    private var lista: ArrayList<Pais>, private var context: Context
) : BaseAdapter() {


    override fun getCount(): Int {
        return lista.size;
    }

    override fun getItem(p0: Int): Pais {
        return lista.get(p0)
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong();
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        var view: View = LayoutInflater
            .from(context).inflate(R.layout.item_lista,p2,false) ;

        // recupero el objeto con el que tengo que trabajar
        var pais: Pais = lista.get(p0);

        // recuperar los elemento graficos donde poner las cosas
        var nombreTexto: TextView = view.findViewById(R.id.nombre_fila)
        var estrellaTexto: TextView = view.findViewById(R.id.estrella_fila)
        var escudoImagen: ImageView = view.findViewById(R.id.imagen_lista)

        nombreTexto.setText(pais.nombre)
        estrellaTexto.setText(pais.estrella)
        escudoImagen.setImageResource(pais.imagen)
        return view;
    }
}