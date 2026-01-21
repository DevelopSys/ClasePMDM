package com.example.agendajson.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.agendajson.MainActivity
import com.example.agendajson.R
import com.example.agendajson.databinding.ActivityMainBinding
import com.example.agendajson.databinding.ItemCardUserBinding
import com.example.agendajson.model.Usuario
import com.example.agendajson.ui.dialog.DialogUser

class AdapterUser(var context: Context) :
    RecyclerView.Adapter<AdapterUser.MyHolder>() {

    private lateinit var lista: ArrayList<Usuario>
    private lateinit var listener: OnUserAdapterListener

    init {
        lista = ArrayList<Usuario>()
        listener = context as MainActivity
    }

    inner class MyHolder(var binding: ItemCardUserBinding)
        : RecyclerView.ViewHolder(binding.root){

            init {
               binding.toolbarUsuario.inflateMenu(R.menu.menu_user)
                binding.toolbarUsuario.setOnMenuItemClickListener {
                    when(it.itemId){
                        R.id.menu_user_detail->{
                            listener.onDetailSelected(lista[bindingAdapterPosition])
                        }
                        R.id.menu_user_fav->{

                        }
                    }

                    return@setOnMenuItemClickListener true
                }
            }

        }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyHolder {

        val binding: ItemCardUserBinding =
            ItemCardUserBinding.inflate(
                LayoutInflater.from(context),
                parent, false
            )
        return MyHolder(binding)
    }

    override fun onBindViewHolder(
        holder: MyHolder,
        position: Int
    ) {
        val user = lista[position]
        holder.binding.toolbarUsuario.title = user.gender
        holder.binding.textEmail.text = user.email.toString()
        holder.binding.textName.text = "${user.firstName} ${user.lastName}"
        Glide.with(context).load(user.image).into(holder.binding.imageUser)
    }

    override fun getItemCount(): Int {
        return this.lista.size
    }

    fun addUser(user: Usuario) {
        this.lista.add(user)
        notifyItemInserted(lista.size-1)
    }

    fun clearUsers()
    {
        lista.clear()
        notifyDataSetChanged()
    }


    interface OnUserAdapterListener{
        fun onDetailSelected(usuario: Usuario)
    }


}