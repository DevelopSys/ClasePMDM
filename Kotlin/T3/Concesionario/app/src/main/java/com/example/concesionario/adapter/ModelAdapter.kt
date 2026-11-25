package com.example.concesionario.adapter

import android.R
import android.content.Context
import android.content.Intent
import android.opengl.GLU
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.concesionario.MainActivity
import com.example.concesionario.activity.DetailActivity
import com.example.concesionario.databinding.ItemCardBinding
import com.example.concesionario.model.Marca
import com.example.concesionario.model.Model
import com.squareup.picasso.Picasso

class ModelAdapter(
    var list: List<Model>,
    var context: Context
) : RecyclerView.Adapter<ModelAdapter.MyHolder>() {

    private lateinit var listener: OnModelSelectedListener

    inner class MyHolder(var binding: ItemCardBinding) :
        RecyclerView.ViewHolder(binding.root) {
    }

    init {
        listener = context as OnModelSelectedListener
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyHolder {

        // MyHolder(var binding: ItemCardBinding)
        val binding: ItemCardBinding = ItemCardBinding.inflate(
            LayoutInflater.from(context), parent,
            false
        )
        return MyHolder(binding)
    }

    override fun onBindViewHolder(
        holder: MyHolder,
        position: Int
    ) {
        val model: Model = list[position]
        holder.binding.txtModel.text = model.name
        // holder.binding.imageCar.setImageDrawable()
        Picasso.get().load(model.image)
            .placeholder(com.example.concesionario.R.drawable.car)
            .into(holder.binding.imageCar)
        holder.binding.btnDetail.setOnClickListener {
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra("model", model)
            context.startActivity(intent)
        }
        holder.binding.btnFav.setOnClickListener {
            listener.onModelSelected(model)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }


    // Cambia la lista actual por la lista que te dicen
    fun setListModels(list: List<Model>) {
        this.list = list;
        this.notifyDataSetChanged()
    }

    interface OnModelSelectedListener{
        fun onModelSelected(model: Model)
    }

}