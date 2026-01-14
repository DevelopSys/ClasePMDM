package com.example.agendajson.adapter

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import com.example.agendajson.databinding.ActivityMainBinding
import com.example.agendajson.databinding.ItemCardUserBinding

class AdapterUser(var context: Context):
    RecyclerView.Adapter<AdapterUser.MyHolder>() {

    inner class MyHolder( binding: ItemCardUserBinding )
        : RecyclerView.ViewHolder(binding.root)
}