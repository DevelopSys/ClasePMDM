package com.example.t3_ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.t3_ui.R
import com.example.t3_ui.model.Modelo
import com.google.android.material.snackbar.Snackbar

class AdaptadorRecycler(var lista: ArrayList<Modelo>) :
    RecyclerView.Adapter<AdaptadorRecycler.MyHolder>() {

    class MyHolder(item: View) : RecyclerView.ViewHolder(item) {
        var imagen: ImageView
        var nombreModelo: TextView
        var valoracionModelo: TextView
        var boton: Button

        init {
            imagen = item.findViewById(R.id.imagen_modelo)
            nombreModelo = item.findViewById(R.id.nombre_modelo)
            valoracionModelo = item.findViewById(R.id.valoracion_modelo)
            boton = item.findViewById(R.id.boton_detalles)
        }
    }

    // crea el patron
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            MyHolder {
        // para crear un patron necesito un view
        val vista: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_recycler,parent,false)
        return MyHolder(vista);
    }

    // asocia elementos en una posicion al patron que le pasa el metodo
    // anterior
    override fun onBindViewHolder(holder: MyHolder, position: Int) {

        val item = lista[position]
        holder.imagen.setImageResource(item.imagen)
        holder.nombreModelo.text = item.nombre
        holder.valoracionModelo.text = item.valoracion.toString()
        holder.boton.setOnClickListener {
            Snackbar.make(holder.boton, item.marca, Snackbar.LENGTH_SHORT).show()
        }

    }

    // cuantos elementos tienes que pintar en una lista
    override fun getItemCount(): Int {
        return lista.size
    }

}