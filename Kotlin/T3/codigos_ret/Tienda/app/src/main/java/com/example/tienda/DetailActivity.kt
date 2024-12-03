package com.example.tienda

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tienda.databinding.ActivityDetailBinding
import com.example.tienda.databinding.ActivityMainBinding
import com.example.tienda.model.Producto

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    private lateinit var producto1: Producto
    private lateinit var producto2: Producto
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val bundle = intent.extras!!.getBundle("datos")
        producto1 = bundle!!.getSerializable("producto1") as Producto;
        producto2 = bundle.getSerializable("producto2") as Producto;
        val tipo: Int = bundle.getInt("tipo")
        when (tipo) {
            0 -> {
                configurarCategoria()
            }

            1 -> {
                configurarPrecio()
            }
        }
    }

    private fun configurarPrecio() {
        if (producto1.precio > producto2.precio) {

        } else {

        }
    }

    private fun configurarCategoria() {
        if (producto1.categoria.equals(producto2.categoria, true)) {

        } else {

        }
    }
}