package com.example.agendajson.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.agendajson.MainActivity
import com.example.agendajson.R
import com.example.agendajson.databinding.ActivityMainBinding
import com.example.agendajson.databinding.ItemUserCardBinding
import com.example.agendajson.model.User
import com.example.agendajson.ui.dialog.DialogUser
import kotlin.random.Random

class UserAdapter(var context: Context) : RecyclerView.Adapter<UserAdapter.MyHolder>() {

    private var lista: ArrayList<User>
    private lateinit var listener: OnItemUserListener

    inner class MyHolder(var binding: ItemUserCardBinding) : RecyclerView.ViewHolder(binding.root) {
        // ejecutamos el inflado en la creacion del holder
        init {
            binding.toolbarCard.inflateMenu(R.menu.user_menu)
            binding.toolbarCard.setOnMenuItemClickListener {
                when(it.itemId){
                    R.id.menu_user_detalle->{
                        listener.onUserDetailSelected(lista[bindingAdapterPosition])
                    }
                    R.id.menu_user_fav->{}
                }
                return@setOnMenuItemClickListener true
            }
        }

    }

    init {
        lista = ArrayList()
        listener = context as MainActivity
    }

    fun clearUsers(): Unit {
        lista.clear()
        notifyDataSetChanged()
    }

    fun addUSer(user: User): Unit {
        this.lista.add(user)
        notifyItemInserted(lista.size - 1)
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
        //holder.binding.toolbarCard.inflateMenu(R.menu.user_menu)
        Glide.with(context).load(user.image).into(holder.binding.imagenCard)

    }


    override fun getItemCount(): Int {
        return lista.size
    }

    interface OnItemUserListener{
        fun onUserDetailSelected(user: User)
    }


}