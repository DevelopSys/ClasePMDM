package com.example.inicio

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.inicio.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.botonPulsar.setOnClickListener {
            if (binding.editNombre.text.toString().isEmpty()){
                Snackbar.make(
                    binding.root,
                    "No hay datos",
                    Snackbar.LENGTH_SHORT
                ).show()
            } else {
                Snackbar.make(
                    binding.root,
                    "Perfecto ${binding.editNombre.text.toString()} " +
                            "has completado la practica",
                    Snackbar.LENGTH_SHORT
                ).show()
            }
        }
        binding.botonPasar.setOnClickListener {
            val intent = Intent(applicationContext, SecondActivity::class.java)
            //intent.putExtra("nombre",binding.editNombre.text.toString())
            startActivity(intent)
        }

    }
}
















