package com.example.agendajson.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.agendajson.databinding.ActivityMainBinding
import com.example.agendajson.databinding.ItemUserCardBinding
import com.example.agendajson.model.User

class UserAdapter(var context: Context) : RecyclerView.Adapter<UserAdapter.MyHolder>() {

    private var lista: ArrayList<User>

    inner class MyHolder(var binding: ItemUserCardBinding) : RecyclerView.ViewHolder(binding.root)

    init {
        lista = ArrayList()
    }


    fun addUSer(user: User): Unit {
        this.lista.add(user)
        notifyItemInserted(lista.size-1)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyHolder {
        val binding = ItemUserCardBinding.inflate(
            LayoutInflater.from(context),
            parent,
            false
        )
        return MyHolder(binding)
    }

    override fun onBindViewHolder(
        holder: MyHolder,
        position: Int
    ) {

        val user = lista[position]
        holder.binding.textoCard.text = user.email
        holder.binding.toolbarCard.title = user.firstName
        Glide.with(context).load(user.image).into(holder.binding.imagenCard)
    }

    override fun getItemCount(): Int {
        return lista.size
    }


}