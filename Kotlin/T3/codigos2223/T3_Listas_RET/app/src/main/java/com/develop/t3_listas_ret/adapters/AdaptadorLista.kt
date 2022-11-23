package com.develop.t3_listas_ret.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.develop.t3_listas_ret.R
import com.develop.t3_listas_ret.model.Usuario

class AdaptadorLista(var lista: ArrayList<Usuario>, var context: Context): BaseAdapter() {

    override fun getCount(): Int {
        return lista.size
    }

    override fun getItem(p0: Int): Usuario {
        return lista.get(p0)
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {

        var view: View = LayoutInflater.from(context).inflate(R.layout.list_item,p2,false)

        var imagen: ImageView = view.findViewById(R.id.imagen_fila)
        var nombre: TextView = view.findViewById(R.id.nombre_fila)

        var usuario = lista.get(p0);

        nombre.setText(usuario.nombre)
        if (usuario.genero == "masculino"){
            imagen.setImageResource(R.drawable.male)
        } else if (usuario.genero == "femenino"){
            imagen.setImageResource(R.drawable.female)
        }
        return view;
    }
}