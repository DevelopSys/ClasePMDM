package com.example.tienda

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tienda.adapters.AdaptadorProductos
import com.example.tienda.data.DataSet
import com.example.tienda.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adaptadorProductos: AdaptadorProductos
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        instancias()

    }

    private fun instancias() {
        adaptadorProductos = AdaptadorProductos(DataSet.lista, this)
        binding.recyclerProductos.adapter = adaptadorProductos
        if (resources.configuration.orientation == 1){
            binding.recyclerProductos.layoutManager =
                LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        } else {
            binding.recyclerProductos.layoutManager =
                GridLayoutManager(this, 2, LinearLayoutManager.VERTICAL, false)
        }
        /*binding.recyclerProductos.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)*/

    }
}