package com.example.tienda.adapter

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tienda.R
import com.example.tienda.databinding.ItemProductoBinding
import com.example.tienda.dataset.DataSet
import com.example.tienda.model.Producto
import com.example.tienda.ui.activities.DetalleActivity
import com.google.android.material.snackbar.Snackbar

class AdapterProducto(var lista: ArrayList<Producto>, var contexto: Context) :
    RecyclerView.Adapter<AdapterProducto.MyHolder>() {
    var listener: OnProductoCarritoListener

    init {
        listener = contexto as OnProductoCarritoListener
    }


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
        Glide.with(contexto)
            .load(producto.imagen)
            .placeholder(R.drawable.producto)
            .into(holder.binding.imagenFila)


        holder.binding.nombreFila.text = producto.nombre
        holder.binding.btnDetalle.setOnClickListener {
            val intent: Intent = Intent(contexto, DetalleActivity::class.java)
            intent.putExtra("producto", producto)
            contexto.startActivity(intent)
        }
        holder.binding.btnCompra.setOnClickListener {
            DataSet.addProducto(producto)
            // lanzar la accion de add carrito
            listener.actualizarContadorCarrito()
        }
        holder.binding.btnComparar.setOnClickListener {
            listener.compararProducto(producto)
        }
    }

    // cuantos elementso tendre que pintar
    override fun getItemCount(): Int {
        return lista.size
    }

    fun chageList(lista: ArrayList<Producto>){
        Log.v("test",lista.size.toString())
        this.lista = lista;
        notifyDataSetChanged()
        // notificaciones individuales
    }

    interface OnProductoCarritoListener {
        fun actualizarContadorCarrito(): Unit
        fun compararProducto(producto: Producto)

    }

}