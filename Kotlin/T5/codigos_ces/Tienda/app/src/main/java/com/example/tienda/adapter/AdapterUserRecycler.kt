package com.example.tienda.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tienda.databinding.ItemRecyclerBinding
import com.example.tienda.model.User

class AdapterUserRecycler(var context: Context) :
    RecyclerView.Adapter<AdapterUserRecycler.MyHolder>() {

    private lateinit var lista: ArrayList<User>

    init {
        lista = ArrayList<User>()
    }

    inner class MyHolder(var binding: ItemRecyclerBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyHolder {
        val binding: ItemRecyclerBinding = ItemRecyclerBinding
            .inflate(
                LayoutInflater.from(context),
                parent, false
            )

        return MyHolder(binding)
    }

    override fun onBindViewHolder(
        holder: MyHolder,
        position: Int
    ) {
        val user: User = lista[position]
        holder.binding.nombreUsuario.text = user.nombre
    }

    override fun getItemCount(): Int {
        return lista.size
    }

    fun addUser(x: User): Unit {
        this.lista.add(x)
        notifyItemInserted(lista.size - 1)
        // notifyDataSetChanged()
    }

}