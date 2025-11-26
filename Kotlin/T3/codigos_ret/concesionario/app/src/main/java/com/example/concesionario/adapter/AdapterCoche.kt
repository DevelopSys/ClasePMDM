package com.example.concesionario.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.concesionario.R
import com.example.concesionario.databinding.ItemCocheBinding
import com.example.concesionario.model.Coche
import com.google.android.material.snackbar.Snackbar

// 2. Indico el tipado del adapter como la clase inner
// 3. Implemento los metodos abs

class AdapterCoche(var lista: ArrayList<Coche>, var contexto: Context) :
    RecyclerView.Adapter<AdapterCoche.MyHolder>() {
    // 1. creo la clase anidada
    inner class MyHolder(var vista: View) : RecyclerView.ViewHolder(vista) {
        val textoPrecio: TextView = vista.findViewById(R.id.txtPrecioCoche)
        val imagenCoche: ImageView = vista.findViewById(R.id.imagenCoche)
        val botonDetalle: Button = vista.findViewById(R.id.btnDetalleCoche)
    }

    // crea el patron -> MyHolder()
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyHolder {
        val binding = LayoutInflater.from(contexto)
            .inflate(R.layout.item_coche, parent, false)
        return MyHolder(binding)
    }

    // asocia el patron con el elemento de la posicion
    override fun onBindViewHolder(
        holder: MyHolder,
        position: Int
    ) {
        val coche = lista[position]
        Glide.with(contexto).load(coche.imagen)
            .placeholder(R.drawable.logo_coche).into(holder.imagenCoche)
        holder.textoPrecio.setText(coche.precio.toString())
        holder.botonDetalle.setOnClickListener {
            Snackbar.make(
                holder.botonDetalle, "Los detalles del coche son ${coche.detalle}",
                Snackbar.LENGTH_SHORT
            ).show()
        }
    }

    // indicar cuantos elementos se deben representar
    override fun getItemCount(): Int {
        return lista.size
    }


}