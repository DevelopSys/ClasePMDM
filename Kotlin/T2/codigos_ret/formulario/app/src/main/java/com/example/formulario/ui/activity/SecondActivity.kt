package com.example.formulario.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.formulario.R
import com.example.formulario.databinding.ActivityMainBinding
import com.example.formulario.databinding.ActivitySecondBinding
import com.example.formulario.model.Usuario

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding
    private var datosRecuperados: Bundle? = null;
    private var usuarioRecuperado: Usuario? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // recuperar datos
        // intent -> bundle -> string
        datosRecuperados = intent.extras?.getBundle("datos")
        usuarioRecuperado = datosRecuperados?.getSerializable("usuario") as Usuario
    }
    override fun onStart() {
        super.onStart()
        binding.textoNombre.text =  "${resources.getString(R.string.name)} ${usuarioRecuperado?.nombre ?: "sin datos"}"
        binding.textoCorreo.text = "${resources.getString(R.string.mail)} ${usuarioRecuperado?.correo ?: "sin correo"}"
        binding.textoPass.text = "${resources.getString(R.string.pass)} ${usuarioRecuperado?.pass ?: "sin pass"}"
        if (usuarioRecuperado?.recordar ?:false) {
            binding.textoRecordar.setText(R.string.pass_remember)
        } else {
            binding.textoRecordar.setText(R.string.pass_no_remember)
        }
    }
}