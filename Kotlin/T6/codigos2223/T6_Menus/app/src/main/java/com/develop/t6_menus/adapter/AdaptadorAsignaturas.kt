package com.develop.t6_menus.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.develop.t6_menus.R
import com.develop.t6_menus.model.Asignatura

class AdaptadorAsignaturas(var listaAsignaturas: ArrayList<Asignatura>, var contexto: Context) :
    RecyclerView.Adapter<AdaptadorAsignaturas.MyHolder>() {

    private lateinit var listener: OnRecyclerAsignaturaListener

    init {
        listener = contexto as OnRecyclerAsignaturaListener
    }

    inner class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var itemNombre: TextView

        init {
            itemNombre = itemView.findViewById(R.id.nombre_item);
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {

        val vista = LayoutInflater.from(contexto).inflate(R.layout.item_recycler, parent, false)
        // val holder = MyHolder(vista)
        return MyHolder(vista)
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {

        val asignatura = listaAsignaturas[position]
        holder.itemNombre.setText(asignatura.nombre)
        holder.itemNombre.setOnClickListener {
            listener.onAsignaturaRecyclerSelected(asignatura)
        }
    }

    fun addAsignatura(asignatura: Asignatura){
        this.listaAsignaturas.add(asignatura)
        notifyItemInserted(listaAsignaturas.size-1)
    }
    
    /*fun filtrarHoras(horas: Int){
        this.listaAsignaturas.filter {
            it.horas == horas
        }
        // lista-> ya filtrada
    }*/

    fun clearAsignaturas() {
        this.listaAsignaturas.clear();
        this.notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return listaAsignaturas.size
    }

    interface OnRecyclerAsignaturaListener{
        fun onAsignaturaRecyclerSelected(asignatura: Asignatura)
    }
}