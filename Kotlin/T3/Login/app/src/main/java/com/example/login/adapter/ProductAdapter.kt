package com.example.login.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.login.R
import com.example.login.databinding.ItemProductBinding
import com.example.login.model.Product

class ProductAdapter(var list: List<Product>, var context: Context) :
    RecyclerView.Adapter<ProductAdapter.MyHolder>() {

    inner class MyHolder(var binding: ItemProductBinding) : RecyclerView.ViewHolder(binding.root) {
        // en el xml
        // var imagen: ImageView = itemView.findViewById(R.id.imageProduct)
    }

    // crear el patron general
    override fun onCreateViewHolder(
        p0: ViewGroup,
        p1: Int
    ): MyHolder {

        val binding: ItemProductBinding = ItemProductBinding.inflate(
            LayoutInflater.from(context),
            p0, false
        )
        return MyHolder(binding)
    }

    // los elementos que ves en pantalla. asocia lo grafico (MyHolder) con un dato (posicion de una lista)
    override fun onBindViewHolder(
        p0: MyHolder,
        p1: Int
    ) {
        // p0.binding.imageProduct
        val product: Product = list[p1]
        p0.binding.textTitle.text = product.title
        p0.binding.textPrice.text = product.price.toString()
        // p0.binding.imageProduct.setImageResource()
        Glide.with(context).load(product.image)
            .placeholder(R.drawable.logo)
            .into(p0.binding.imageProduct)

    }

    // cantidad de elementos a mostrar en total -> el size de una lista
    override fun getItemCount(): Int {
        return list.size
    }


}