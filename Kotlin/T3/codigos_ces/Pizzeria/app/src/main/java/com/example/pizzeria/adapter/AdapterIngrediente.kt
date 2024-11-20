package com.example.pizzeria.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.pizzeria.R
import com.example.pizzeria.model.Ingrediente
import com.example.pizzeria.model.Pizza
import com.google.android.material.snackbar.Snackbar

class AdapterIngrediente(
    var lista: ArrayList<Ingrediente>,
    var context: Context
) : BaseAdapter() {
    override fun getCount(): Int {
        return lista.size
    }

    override fun getItem(p0: Int): Ingrediente {
        return lista[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val vista: View = LayoutInflater.from(context)
            .inflate(R.layout.item_ingrediente, p2, false)
        val textoNombre: TextView = vista.findViewById(R.id.textIngrediente)
        val textoInfo: TextView = vista.findViewById(R.id.textInfoIngrediente)
        val imagen: ImageView = vista.findViewById(R.id.imageViewIngrediente)
        val ingrediente = lista[p0]

        imagen.setOnClickListener {
            Snackbar.make(
                it,
                "El elemento seleccionado es ${ingrediente.nombre}",
                Snackbar.LENGTH_SHORT
            ).show()
        }

        // val ingrediente = getItem(p0)
        textoInfo.text = ingrediente.info
        textoNombre.text = ingrediente.nombre
        imagen.setImageResource(ingrediente.imagen)

        return vista
    }

    fun changeList(lista: ArrayList<Ingrediente>) {
        this.lista = lista
        notifyDataSetChanged()
    }

    fun removeIng(posicion: Int) {
        lista.removeAt(posicion)
        notifyDataSetChanged()
    }
}