package com.example.concesionario.ui

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.concesionario.R
import com.example.concesionario.databinding.ActivityDetailBinding
import com.example.concesionario.model.Marca
import com.example.concesionario.model.Modelo

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    private lateinit var modelo: Modelo
    private lateinit var marca: Marca
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val bundleRecuperado: Bundle = intent.getBundleExtra("datos")!!
        modelo = bundleRecuperado.getSerializable("modelo") as Modelo
        marca = bundleRecuperado.getSerializable("marca") as Marca
        binding.imagenDetalle.setImageResource(modelo.imagen)
        binding.logoDetalle.setImageResource(marca.imagen!!)
        binding.marcaDetalle.text = marca.nombre!!

    }
}