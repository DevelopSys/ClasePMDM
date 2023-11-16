package com.example.t3_ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.t3_ui.databinding.ActivityDetailBinding
import com.example.t3_ui.model.Modelo

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    private lateinit var coche: Modelo;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        coche = intent.extras!!.getSerializable("modelo") as Modelo;

    }

    override fun onResume() {
        super.onResume()
        binding.nombreModelo.text = coche.nombre;
        binding.cvModelo.text = coche.cv.toString();
        binding.imagenMarca.setImageResource(coche.marca.imagen)
        binding.imagenModelo.setImageResource(coche.imagen)
    }
}