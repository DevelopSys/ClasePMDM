package com.example.tienda.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tienda.databinding.ItemProductoBinding
import com.example.tienda.model.Producto

class AdapterProducto(var lista: ArrayList<Producto>, var contexto: Context) :
    RecyclerView.Adapter<AdapterProducto.MyHolder>() {
    inner class MyHolder(var binding: ItemProductoBinding) : RecyclerView.ViewHolder(binding.root)

    // crea un holder de la clase anidada
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyHolder {
        var binding: ItemProductoBinding =
            ItemProductoBinding.inflate(LayoutInflater.from(contexto), parent, false)
        return MyHolder(binding)
    }

    // asociar los elementos (posicion) con el holder asociado
    override fun onBindViewHolder(
        holder: MyHolder,
        position: Int
    ) {
        val producto: Producto = lista[position]
        holder.binding.nombreFila.text = producto.nombre
        holder.binding.btnDetalle.setOnClickListener {  }
        holder.binding.btnCompra.setOnClickListener {  }
    }

    // cuantos elementso tendre que pintar
    override fun getItemCount(): Int {
        return lista.size
    }


}