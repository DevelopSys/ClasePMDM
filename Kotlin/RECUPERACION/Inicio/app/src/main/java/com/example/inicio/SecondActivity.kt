package com.example.inicio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.inicio.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding
    private lateinit var nombre: String;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        nombre = intent.getStringExtra("nombre") ?: "por defecto"
        binding.textoRecuperar.text = nombre;

    }
}