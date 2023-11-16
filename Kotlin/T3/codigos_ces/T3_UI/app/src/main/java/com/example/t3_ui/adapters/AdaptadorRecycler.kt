package com.example.t3_ui.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.view.ContentInfoCompat.Flags
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.t3_ui.DetailActivity
import com.example.t3_ui.R
import com.example.t3_ui.model.Modelo
import com.google.android.material.snackbar.Snackbar

class AdaptadorRecycler(
    var lista: ArrayList<Modelo>,
    var contexto: Context
) : RecyclerView.Adapter<AdaptadorRecycler.MyHolder>() {

    private lateinit var listener: OnModeloListener


    init {
        listener = contexto as OnModeloListener
    }

    class MyHolder(item: View) : ViewHolder(item) {
        // elementos
        var imagen: ImageView
        var nombre: TextView
        var precio: TextView
        var botonDetalle: Button
        var botonComparar: Button

        init {
            imagen = item.findViewById(R.id.imagen_modelo)
            nombre = item.findViewById(R.id.nombre_modelo)
            precio = item.findViewById(R.id.precio_modelo)
            botonDetalle = item.findViewById(R.id.boton_detalle)
            botonComparar = item.findViewById(R.id.boton_comparar)

        }
    }

    // indica el numero de los elementos a pintar
    override fun getItemCount(): Int {
        return lista.size
    }

    // crea un patron
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            : MyHolder {
        // view -> XML
        val view: View = LayoutInflater.from(contexto)
            .inflate(R.layout.item_recycler, parent, false)
        return MyHolder(view)
    }


    // juntar el patron con los datos
    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val item: Modelo = lista[position]
        holder.imagen.setImageResource(item.imagen)
        holder.nombre.text = item.nombre
        holder.precio.text = item.precio.toString()
        holder.botonDetalle.setOnClickListener {


            val intent: Intent = Intent(contexto, DetailActivity::class.java);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            intent.putExtra("modelo",item)
            contexto.startActivity(intent)


            /*Snackbar.make(
                holder.boton, "El coche tiene ${item.cv}",
                Snackbar.LENGTH_SHORT
            ).show()*/
        }
        holder.imagen.setOnLongClickListener {
            notifyItemRemoved(position)
            lista.removeAt(position)
            //notifyDataSetChanged()

            return@setOnLongClickListener true
        }
        holder.botonComparar.setOnClickListener {
            listener.onModeloSelected(item)
        }
    }


    interface OnModeloListener{

        fun onModeloSelected(modelo: Modelo)

    }

}