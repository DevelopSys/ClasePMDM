package com.develop.t6_menus_ret

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.RecyclerView
import com.develop.t6_menus_ret.model.Asignatura
import com.google.android.material.snackbar.Snackbar

class AdaptadorAsignaturas(var listaDatos: ArrayList<Asignatura>, var context: Context): RecyclerView.Adapter<AdaptadorAsignaturas.MyHolder>(){

    inner class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textoNombre: TextView
         var imagenAsignatura: ImageView
         var toolbarDetalle: Toolbar

        init {
            textoNombre = itemView.findViewById(R.id.texto_item)
            toolbarDetalle = itemView.findViewById(R.id.toolbar_item)
            imagenAsignatura = itemView.findViewById(R.id.imagen_detalle)
        }
    }

    fun agregarDato(asignatura: Asignatura){
        listaDatos.add(asignatura)
        notifyItemInserted(listaDatos.size-1)
    }

    fun vaciarLista(){
        listaDatos.clear()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val vista = LayoutInflater.from(context).inflate(R.layout.item_recycler,parent,false)
        return MyHolder(vista)
    }

    // para las asignaturas de primero --> menu (ver temario / ver profesor)
    // para las asignaturas de segundo --> menu (ver detalles / ver horas)

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val asignatura = listaDatos[position]

        holder.imagenAsignatura.setImageResource(asignatura.imagen)
        holder.toolbarDetalle.setTitle(asignatura.nombre)

        

        holder.toolbarDetalle.setOnMenuItemClickListener {

            when(it.itemId){
                R.id.menu_item_detalle->{
                    Snackbar.make(holder.imagenAsignatura,"${asignatura.ciclo}", Snackbar.LENGTH_SHORT).show()
                }
                R.id.menu_item_mas_detalle->{
                    Snackbar.make(holder.imagenAsignatura,"${asignatura.horas}", Snackbar.LENGTH_SHORT).show()
                }
            }

            return@setOnMenuItemClickListener true
        }

        holder.textoNombre.text = asignatura.nombre
        holder.textoNombre.setOnLongClickListener {
            listaDatos.remove(asignatura)
            this.notifyItemRemoved(position)
            return@setOnLongClickListener true
        }
    }

    override fun getItemCount(): Int {
        return listaDatos.size
    }
}