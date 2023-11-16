package com.example.t3_ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.t3_ui.databinding.ActivityDetailBinding
import com.example.t3_ui.model.Modelo

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    private lateinit var modelo: Modelo;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        modelo = intent.extras!!.getSerializable("modelo") as Modelo

    }

    override fun onStart() {
        super.onStart()
        binding.imagenModelo.setImageResource(modelo.imagen)
        binding.imagenMarca.setImageResource(modelo.marca.imagen)
        binding.nombreModelo.text = modelo.nombre

    }
}