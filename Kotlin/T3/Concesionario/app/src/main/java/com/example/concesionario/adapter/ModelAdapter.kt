package com.example.concesionario.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.concesionario.databinding.ItemCardBinding

class ModelAdapter : RecyclerView.Adapter<ModelAdapter.MyHolder>() {

    inner class MyHolder(var binding: ItemCardBinding)
        : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        p0: ViewGroup,
        p1: Int
    ): MyHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(
        p0: MyHolder,
        p1: Int
    ) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }


}