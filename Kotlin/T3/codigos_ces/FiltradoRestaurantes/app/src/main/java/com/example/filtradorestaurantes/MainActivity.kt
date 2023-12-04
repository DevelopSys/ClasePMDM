package com.example.filtradorestaurantes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.filtradorestaurantes.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.botonFiltro.setOnClickListener{
            val intent = Intent(applicationContext,ListaActivity::class.java);
            intent.putExtra("localidad",binding.spinnerLocalidades.selectedItem.toString())
            intent.putExtra("puntuacion",binding.spinnerPunctuaciones.selectedItem.toString().toInt())
            intent.putExtra("comida", binding.spinnerComida.selectedItem.toString())
            startActivity(intent)
        }

    }
}