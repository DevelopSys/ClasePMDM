package com.example.concesionario.adapter

import android.R
import android.content.Context
import android.opengl.GLU
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.concesionario.databinding.ItemCardBinding
import com.example.concesionario.model.Model
import com.squareup.picasso.Picasso

class ModelAdapter(
    var list: List<Model>,
    var context: Context
) : RecyclerView.Adapter<ModelAdapter.MyHolder>() {

    inner class MyHolder(var binding: ItemCardBinding) :
        RecyclerView.ViewHolder(binding.root)

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
    }

    override fun getItemCount(): Int {
        return list.size
    }


}