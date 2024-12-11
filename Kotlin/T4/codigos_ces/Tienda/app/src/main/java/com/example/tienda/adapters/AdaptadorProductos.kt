package com.example.tienda.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.tienda.R
import com.example.tienda.model.Producto
import com.example.tienda.ui.DetaiActivity
import com.google.android.material.snackbar.Snackbar

class AdaptadorProductos(var lista: ArrayList<Producto>, var context: Context
, var funcion: ((Double)-> Unit)?=null) :
    RecyclerView.Adapter<AdaptadorProductos.MyHolder>() {
    private lateinit var listener: OnProductoListener

    init {
        listener = context as OnProductoListener
    }

    class MyHolder(item: View, adaptadorProductos: AdaptadorProductos) : ViewHolder(item) {

        // cualquier evento asociado a una posicion -> AQUI
        var texto: TextView = item.findViewById(R.id.textoProducto)
        var imagen: ImageView = item.findViewById(R.id.imagenProducto)
        var boton: Button = item.findViewById(R.id.botonComparar)

        init {

            imagen.setOnLongClickListener {
                adaptadorProductos.removeItem(adapterPosition)
                return@setOnLongClickListener true
            }
        }
    }

    fun removeItem(position: Int) {
        lista.removeAt(position)
        notifyItemRemoved(position)
    }

    override fun getItemCount(): Int {
        return lista.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val view = LayoutInflater.from(context).inflate(
            R.layout.ite_recycler,
            parent, false
        )
        val holder: MyHolder = MyHolder(view, this);
        return holder;
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val producto: Producto = lista[position]
        holder.texto.text = producto.nombre
        // https://cdn-icons-png.freepik.com/512/925/925072.png ropa
        // https://cdn-icons-png.freepik.com/256/3206/3206042.png?semt=ais_hybrid tecno
        // https://cdn-icons-png.flaticon.com/512/3248/3248597.png jardin
        var imagen: String = ""
        when (producto.categoria) {
            "ropa" -> imagen = "https://cdn-icons-png.freepik.com/512/925/925072.png"
            "tecnologia" -> imagen =
                "https://cdn-icons-png.freepik.com/256/3206/3206042.png?semt=ais_hybrid"

            "jardin" -> imagen = "https://cdn-icons-png.flaticon.com/512/3248/3248597.png"
        }
        Glide.with(context).load(imagen).placeholder(R.drawable.images).into(holder.imagen)
        holder.boton.setOnClickListener {
            /*Snackbar.make(holder.boton, "Boton pulsado desde el adaptador ${producto.precio}", Snackbar.LENGTH_SHORT)
                .show()*/
            /*val intent: Intent = Intent(context, DetaiActivity::class.java)
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(intent)*/
            listener.onProductoSelected(producto)
        }
        holder.imagen.setOnClickListener {
            funcion?.invoke(producto.precio)
        }

    }

    interface OnProductoListener {
        fun onProductoSelected(producto: Producto)
    }

}