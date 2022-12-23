package com.develop.t4_listasrecycler.adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.develop.t4_listasrecycler.R
import com.develop.t4_listasrecycler.model.Usuario
import com.google.android.material.snackbar.Snackbar

class AdaptadorUsuarios(var lista: ArrayList<Usuario>, var contexto: Context) :
    RecyclerView.Adapter<AdaptadorUsuarios.MyHolder>() {

    private lateinit var listener: OnRecyclerUsuarioListener

    init {
        //OnRecyclerUsuarioListener = OnRecyclerUsuarioListener
        listener = contexto as OnRecyclerUsuarioListener
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        var vista: View = LayoutInflater.from(contexto).inflate(
            R.layout.item_recycler, parent,
            false
        ); // xml aspecto de cada fila
        return MyHolder(vista);
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        var usuarioActual = lista.get(position)
        holder.textoNombre.setText(usuarioActual.nombre) // en el textview del xml
        holder.textoApellido.setText(usuarioActual.apellido) // en el textview del xml
        holder.imagenUsuario.setImageResource(usuarioActual.imagen) // en el textview del xml
        holder.textoNombre.setOnClickListener {
            // comunicar el usuario
            listener.onUsuarioSelected(usuarioActual)
        }
        //holder.textoNombre.setOnClickListener { Log.v("lista", "Texto nombre pulsado") }
        holder.textoApellido.setOnClickListener { Log.v("lista", "Texto nombre pulsado") }
        holder.imagenUsuario.setOnClickListener {
            Snackbar.make(
                holder.imagenUsuario,
                "Pulsada imagen",
                Snackbar.LENGTH_SHORT
            ).show()
        }
        holder.imagenUsuario.setOnLongClickListener {
            listener.onUsuarioSelected(usuarioActual,position)
            return@setOnLongClickListener true
        }
    }

    override fun getItemCount(): Int {
        // tamaño de la lista
        return lista.size
    }

    interface OnRecyclerUsuarioListener{
        fun onUsuarioSelected(usuario: Usuario)
        fun onUsuarioSelected(usuario: Usuario, posicion: Int)
    }

    inner class MyHolder(itemView: View) : ViewHolder(itemView) {

        var textoNombre: TextView;
        var textoApellido: TextView;
        var imagenUsuario: ImageView;
        var constraintLayout: ConstraintLayout;

        init {
            constraintLayout = itemView.findViewById(R.id.constraint_general)
            textoApellido = itemView.findViewById(R.id.apellido_item)
            textoNombre = itemView.findViewById(R.id.nombre_item)
            imagenUsuario = itemView.findViewById(R.id.imagen_item)
        }

    }
}