package com.example.tareas.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.tareas.R
import com.example.tareas.model.Tarea

class AdaptadorTarea(var lista: ArrayList<Tarea>, var context: Context) : BaseAdapter() {
    override fun getCount(): Int {
        return lista.size
    }

    override fun getItem(p0: Int): Tarea {
        return lista[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val vista: View = LayoutInflater.from(context)
            .inflate(R.layout.item_tarea, p2, false)

        val imagen: ImageView = vista.findViewById(R.id.imagenTarea)
        val nombre: TextView = vista.findViewById(R.id.textoTarea)

        val tarea: Tarea = lista[p0]

        nombre.text = tarea.titulo
        when(tarea.tipo){
            0->{
                imagen.setImageResource(R.drawable.low)
            }
            1->{
                imagen.setImageResource(R.drawable.medium)
            }
            2->{
                imagen.setImageResource(R.drawable.high)
            }
        }

        return vista
    }

    fun changeList(lista: ArrayList<Tarea>){
        this.lista = lista
        notifyDataSetChanged()
    }
}