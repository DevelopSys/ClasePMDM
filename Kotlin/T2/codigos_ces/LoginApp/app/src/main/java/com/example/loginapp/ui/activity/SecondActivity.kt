package com.example.loginapp.ui.activity

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.loginapp.R
import com.example.loginapp.databinding.ActivitySecondBinding
import com.example.loginapp.model.Usuario

class SecondActivity : AppCompatActivity() {

    lateinit var binding: ActivitySecondBinding
    var usuario: Usuario? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        usuario = intent.getSerializableExtra("usuario") as Usuario
        // binding.textoSaludo.setText("Bienvendo  ${intent.getStringExtra("correo")!!}")
        binding.textoSaludo.text = "Bienvendo  ${usuario?.correo}"
        binding.textoPlataforma.text = "Sesion iniciada con ${usuario?.plataforma}"
    }
}