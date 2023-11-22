package com.example.t3_ui.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.t3_ui.DetailActivity
import com.example.t3_ui.MainActivity
import com.example.t3_ui.R
import com.example.t3_ui.model.Modelo
import com.google.android.material.snackbar.Snackbar

class AdaptadorRecycler(
    var lista: ArrayList<Modelo>,
    var contexto: Context
) :
    RecyclerView.Adapter<AdaptadorRecycler.MyHolder>() {

    private lateinit var listener: OnRecyclerModeloListener

    init {
        // OnRecyclerModeloListener = SecondActivity as OnRecyclerListener
        listener = contexto as OnRecyclerModeloListener
    }


    class MyHolder(item: View) : RecyclerView.ViewHolder(item) {
        var imagen: ImageView
        var nombreModelo: TextView
        var valoracionModelo: TextView
        var boton: Button
        var botonComparar: Button;

        init {
            imagen = item.findViewById(R.id.imagen_modelo)
            nombreModelo = item.findViewById(R.id.nombre_modelo)
            valoracionModelo = item.findViewById(R.id.valoracion_modelo)
            boton = item.findViewById(R.id.boton_detalles)
            botonComparar = item.findViewById(R.id.boton_comparar)
        }
    }

    // crea el patron
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            MyHolder {
        // para crear un patron necesito un view
        val vista: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_recycler, parent, false)
        return MyHolder(vista);
    }

    // asocia elementos en una posicion al patron que le pasa el metodo
    // anterior
    override fun onBindViewHolder(
        holder: MyHolder,
        position: Int
    ) {

        val item = lista[position]
        holder.imagen.setImageResource(item.imagen)
        holder.imagen.setOnLongClickListener {
            lista.remove(item)
            //notifyDataSetChanged()
            return@setOnLongClickListener true
        }
        holder.nombreModelo.text = item.nombre
        holder.nombreModelo.setOnClickListener {
            notifyItemMoved(position, position - 1)
        }
        holder.valoracionModelo.text = item.valoracion.toString()
        holder.boton.setOnClickListener {
            //Snackbar.make(holder.boton, item.marca, Snackbar.LENGTH_SHORT).show()
            val intent = Intent(contexto, DetailActivity::class.java)
            intent.putExtra("modelo", item)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            contexto.startActivity(intent)
        }
        holder.botonComparar.setOnClickListener {
            // disparar la acción
            listener.onModeloSelected(item)
        }


    }

    // cuantos elementos tienes que pintar en una lista
    override fun getItemCount(): Int {
        return lista.size
    }


    interface OnRecyclerModeloListener {
        fun onModeloSelected(modelo: Modelo)
    }

}