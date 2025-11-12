package com.example.concesionario.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.concesionario.R
import com.example.concesionario.model.Vehiculo

class AdapterModelos(
    var lista: ArrayList<Vehiculo>,
    var contexto: Context
) : BaseAdapter() {

    // el numero de elementos que se pintaran en el spinner
    override fun getCount(): Int {
        return lista.size;
    }

    // retorna el elemento ubicado en una posicion
    override fun getItem(position: Int): Vehiculo? {
        return lista[position]
    }

    // retorna el id del elemento ubicado en una posicion
    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    // indica como se pinta un elemento ubicado en una posicion concreta
    override fun getView(
        position: Int,
        convertView: View?,
        parent: ViewGroup?
    ): View? {

        // 1. traer el XML para utilizarlo aqui
        val view: View =
            LayoutInflater.from(contexto).inflate(
                R.layout.item_spinner,
                parent, false
            )
        // 2. sacar cada uno de los elementos del XML
        val imagenMarca: ImageView = view.findViewById(R.id.itemMarca)
        val imagenModelo: ImageView = view.findViewById(R.id.itemModelo)
        val textoModelo: TextView = view.findViewById(R.id.itemNombre)
        // 3. rellenar cada uno de los elementos del paso 2
        val modelo = lista[position]
        imagenMarca.setImageResource(modelo.marca.imagen)
        imagenModelo.setImageResource(modelo.imagen)
        textoModelo.setText(modelo.modelo)
        // 4. retorna la vista del paso 1
        return view
    }
}