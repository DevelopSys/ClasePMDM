package com.example.listado

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.listado.adapters.AdaptaderRecycler
import com.example.listado.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: AdaptaderRecycler
    private lateinit var lista: ArrayList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        lista = ArrayList()
        lista.add("Usuario 1")
        lista.add("Usuario 2")
        lista.add("Usuario 3")
        lista.add("Usuario 4")
        adapter = AdaptaderRecycler(lista, this);



        binding.recyclerListado.adapter = adapter;
        binding.recyclerListado.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

    }
}