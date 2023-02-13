package com.example.iniciofragments.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.iniciofragments.R
import com.example.iniciofragments.model.Usuario

class AdaptadorUsuarios (var listaUsuarios: ArrayList<Usuario>, var contexto: Context): RecyclerView.Adapter<AdaptadorUsuarios.MyHolder>() {

    inner class MyHolder(itemView: View) : ViewHolder(itemView) {

         var imagen: ImageView;
         var nombre: TextView;

        init {
            imagen = itemView.findViewById(R.id.imagen_item_recycler)
            nombre = itemView.findViewById(R.id.nombre_item_recycler)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {

        val vista: View = LayoutInflater.from(contexto).inflate(R.layout.item_recycler,
            parent,false)
        return  MyHolder(vista)
    }

    override fun getItemCount(): Int {
        return listaUsuarios.size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {

        val usuario: Usuario = listaUsuarios[position]
        holder.nombre.text = usuario.nombre;
        if (usuario.sexo.equals("m",true)){
            holder.imagen.setImageResource(R.drawable.hombre)
        } else {
            holder.imagen.setImageResource(R.drawable.mujer)
        }

    }
}