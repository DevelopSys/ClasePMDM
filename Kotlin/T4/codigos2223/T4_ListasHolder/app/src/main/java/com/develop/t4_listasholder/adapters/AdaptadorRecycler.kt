package com.develop.t4_listasholder.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.View.OnLongClickListener
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.develop.t4_listasholder.R
import com.develop.t4_listasholder.model.Usuario
import com.google.android.material.snackbar.Snackbar

class AdaptadorRecycler(var context: Context, var lista: ArrayList<Usuario>) :
    RecyclerView.Adapter<AdaptadorRecycler.MyHolder>() {

    // 2. Creo un objeto de la interfaz para poder utilizarlo
    private lateinit var listener: OnRecyclerUsuarioListener

    init {
        // OnRecyclerUsuarioListener =  OnRecyclerUsuarioListener
        listener = context as OnRecyclerUsuarioListener;
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        var view: View = LayoutInflater.from(context).inflate(R.layout.item_recycler, parent, false)
        var holder = MyHolder(view);
        return holder
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {

        // personaliza cada una de las filas -> holder
        var usuarioFila = lista.get(position);
        holder.nombre.setText(usuarioFila.nombre)
        holder.apellido.setText(usuarioFila.apellido)
        holder.correo.setText(usuarioFila.correo)
        holder.nombre.setOnClickListener{
            //Snackbar.make(holder.nombre,"Pulsado nombre ${usuarioFila.nombre}",Snackbar.LENGTH_SHORT).show()
            // 3. Utilizo el método de la interfaz
            listener.comunicaUsuarioSelected(usuarioFila)
        }

        //holder.nombre.setOnLongClickListener(this)
        holder.nombre.setOnLongClickListener{
            // 3. Utilizo el método de la interfaz
            listener.comunicaUsuarioSelected(usuarioFila,position)
            return@setOnLongClickListener true
        }
        holder.apellido.setOnClickListener{
            Snackbar.make(holder.nombre,"Pulsado apellido",Snackbar.LENGTH_SHORT).show()
        }
        holder.correo.setOnClickListener{
            Snackbar.make(holder.nombre,"Pulsado correo",Snackbar.LENGTH_SHORT).show()
        }

        // boton.setOnClick()-->cambiar de pantalla
        /*usuarioFila.apellido
        usuarioFila.nombre
        usuarioFila.correo*/

    }

    override fun getItemCount(): Int {
        return lista.size
    }

    // 1. Origen de los datos creo una interfaz

    interface OnRecyclerUsuarioListener{
        fun comunicaUsuarioSelected(usuario: Usuario)
        fun comunicaUsuarioSelected(usuario: Usuario, posicion: Int)
    }


    // clase anidada
    inner class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var nombre: TextView;
        var correo: TextView;
        var apellido: TextView;

        init {
            nombre = itemView.findViewById(R.id.nombre_fila)
            correo = itemView.findViewById(R.id.correo_fila)
            apellido = itemView.findViewById(R.id.apellido_fila)
        }


    }



}