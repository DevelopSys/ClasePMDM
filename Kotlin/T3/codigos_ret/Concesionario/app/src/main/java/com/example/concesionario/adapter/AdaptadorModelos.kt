package com.example.concesionario.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.concesionario.R
import com.example.concesionario.model.Modelo

class AdaptadorModelos(var listaModelos: ArrayList<Modelo>, var context: Context) : BaseAdapter() {
    override fun getCount(): Int {
        return listaModelos.size
    }

    override fun getItem(p0: Int): Modelo {
        return listaModelos[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val view: View = LayoutInflater.from(context).inflate(R.layout.item_modelo, p2, false)
        val imagen: ImageView = view.findViewById(R.id.imageModelo)
        val texto: TextView = view.findViewById(R.id.textoModelo)
        val modelo = listaModelos[p0]
        imagen.setImageResource(modelo.imagen)
        texto.text = modelo.modelo
        return view
    }

    fun changeList(lista: ArrayList<Modelo>){
        this.listaModelos = lista
        notifyDataSetChanged()
    }
}