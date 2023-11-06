package com.example.t3_ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.t3_ui.R
import com.example.t3_ui.model.Modelo

class AdaptadorSpinnerModelo(var lista: ArrayList<Modelo>, var contexto: Context) : BaseAdapter() {


    // cuantos elementos hay en el spinner
    override fun getCount(): Int {
        return lista.size;
    }

    // obtendra el elemento seleccionado segun una posicion
    override fun getItem(position: Int): Modelo {
        return lista[position]
    }

    // obtener el id asociado al elementos de la posicion
    override fun getItemId(position: Int): Long {
        return position.toLong()
    }


    // renderizar cada una de las filas (con los datos que le toquen)
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?):
            View {
        // tener el XML ->item fila -> LayoutInflater
        //LayoutInflater.from(parent.context)
        // lo que quiero inflar,
        val vista = LayoutInflater.from(contexto)
            .inflate(R.layout.item_modelo, parent, false)

        val modelo = lista[position]
        val textoModelo = vista.findViewById<TextView>(R.id.texto_modelo)
        val imagenModelo = vista.findViewById<ImageView>(R.id.imagen_modelo)
        textoModelo.text =  modelo.nombre
        imagenModelo.setImageResource(modelo.imagen)

        // relleno la vista


        return vista;


    }
}