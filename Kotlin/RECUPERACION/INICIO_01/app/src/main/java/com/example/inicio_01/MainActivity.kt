package com.example.inicio_01

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.inicio_01.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.botonEnviar.setOnClickListener {
            /*val nombre = binding.inputNombre.text.toString()
            val apellido = binding.inputApellido.text.toString()
            val edad = binding.inputEdad.text.toString().toInt()

            binding.textoNombre.text = nombre
            binding.textoApellido.text = apellido
            binding.textoEdad.text = edad.toString()*/
            val intent = Intent(this,SecondActivity::class.java)
            intent.putExtra("nombre",binding.inputNombre.text.toString())
            intent.putExtra("apellido",binding.inputApellido.text.toString())
            intent.putExtra("edad",binding.inputEdad.text.toString().toInt())
            startActivity(intent)
        }


    }
}