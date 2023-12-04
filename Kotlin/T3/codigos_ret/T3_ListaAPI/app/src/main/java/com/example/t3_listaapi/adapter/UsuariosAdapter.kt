package com.example.t3_listaapi.adapter

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SnapHelper
import com.bumptech.glide.Glide
import com.example.t3_listaapi.R
import com.example.t3_listaapi.model.Usuario
import com.google.android.material.snackbar.Snackbar

class UsuariosAdapter(var lista: ArrayList<Usuario>, var contexto: Context) :
    RecyclerView.Adapter<UsuariosAdapter.MyHolder>() {

    class MyHolder(item: View) : RecyclerView.ViewHolder(item) {
        var textoDetalle: TextView;
        var imagenDetalle: ImageView;

        init {
            textoDetalle = item.findViewById(R.id.texto_fila);
            imagenDetalle = item.findViewById(R.id.imagen_fila);
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val vista = LayoutInflater.from(contexto).inflate(R.layout.item_recycler, parent, false)
        return MyHolder(vista)
    }

    override fun getItemCount(): Int {
        return lista.size
    }

    fun vaciarLista(): Unit {
        lista.clear();
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {

        val item = lista[position]
        holder.textoDetalle.text = item.nombre + " " + item.apellido
        Glide.with(contexto).load(item.imagen).into(holder.imagenDetalle)
        holder.imagenDetalle.setOnLongClickListener {
            Snackbar.make(
                holder.imagenDetalle,
                "Quieres realizar la llamada a ${item.telefono}",
                Snackbar.LENGTH_SHORT
            ).setAction("LLamar") {
                    val intent = Intent(Intent.ACTION_CALL,Uri.parse("tel:${item.telefono}"))
                    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                    contexto.startActivity(intent)
            }.show()
            return@setOnLongClickListener true
        }
    }
}