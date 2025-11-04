package com.example.formulario

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.formulario.databinding.ActivitySecondBinding
import com.example.formulario.model.Usuario

class SecondActivity : AppCompatActivity() {


    lateinit var binding: ActivitySecondBinding
    var mailRecuperado: String? = null
    var usuarioRecuperado: Usuario? = null;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //mailRecuperado = intent.getStringExtra("correo")
        usuarioRecuperado = intent.getSerializableExtra("usuario") as Usuario
        binding.textoMail.text = usuarioRecuperado?.mail ?: "sin correo"
    }
}