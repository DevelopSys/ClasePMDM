package com.example.tienda.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tienda.R
import com.example.tienda.databinding.ItemRecyclerBinding
import com.example.tienda.model.User


class AdapterUsers(var context: Context) : RecyclerView.Adapter<AdapterUsers.MyHolder>() {

    private lateinit var listaUsers: ArrayList<User>

    init {
        listaUsers = ArrayList()
    }

    inner class MyHolder(var binding: ItemRecyclerBinding) : RecyclerView.ViewHolder(binding.root) {


        init {
            binding.toolbarItem.inflateMenu(R.menu.menu_toolbar_card)
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyHolder {
        val binding = ItemRecyclerBinding.inflate(LayoutInflater.from(context), parent, false)
        return MyHolder(binding)
    }

    override fun onBindViewHolder(
        holder: MyHolder,
        position: Int
    ) {
        val user = listaUsers[position]

        holder.binding.textoItem.text = user.nombre;
        holder.binding.toolbarItem.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.menu_datail -> {
                    // interfaz de callback para que se navege al detalle
                }
            }
            return@setOnMenuItemClickListener true
        }
    }

    override fun getItemCount(): Int {
        return listaUsers.size
    }

    fun agregarUsuario(user: User) {
        this.listaUsers.add(user)
        notifyItemInserted(listaUsers.size - 1)
    }


}