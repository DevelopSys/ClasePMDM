package com.example.examenusuarios.adaptadores

import android.content.Context
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.examenusuarios.R
import com.example.examenusuarios.model.Element

class RecyclerAdatpter(var contexto: Context, var lista: ArrayList<Element>) :
    RecyclerView.Adapter<RecyclerAdatpter.MyHolder>() {

    class MyHolder(item: View) : RecyclerView.ViewHolder(item) {
        val textoIzq: TextView = item.findViewById(R.id.textoRecyclerIzq)
        val textoDerecha: TextView = item.findViewById(R.id.textoRecyclerDer)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        return MyHolder(
            LayoutInflater.from(contexto).inflate(R.layout.item_recycler, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return lista.size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val item = lista[position]
         holder.textoIzq.text = item.izqu
         holder.textoDerecha.text = item.dere
    }

    fun addElement(x: Element): Unit {
        lista.add(x)
        notifyItemChanged(lista.size -1)
    }
}