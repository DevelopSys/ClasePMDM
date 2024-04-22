package com.example.inicio_01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.inicio_01.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val nombre = intent.getStringExtra("nombre")
        val apellido = intent.getStringExtra("apellido")
        val edad = intent.getIntExtra("edad",0)

        binding.textoNombre.text = nombre;
        binding.textoApellido.text = apellido;
        binding.textoEdad.text = edad.toString();

    }
}