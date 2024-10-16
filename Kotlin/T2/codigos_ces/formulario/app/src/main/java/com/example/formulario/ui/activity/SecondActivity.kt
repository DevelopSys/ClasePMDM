package com.example.formulario.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.formulario.R
import com.example.formulario.databinding.ActivityMainBinding
import com.example.formulario.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val datosRecuperados = intent.getBundleExtra("datos")
        binding.textoNombre.text =datosRecuperados?.getString("nombre") ?: "sin datos extra"
        binding.textoPass.text =datosRecuperados?.getString("pass") ?: "sin datos extra"
        binding.textoCorreo.text =datosRecuperados?.getString("correo") ?: "sin datos extra"

        if (datosRecuperados?.getBoolean("recordar") ?: false){
            binding.textoRecordar.text = "Se esta recordando tu pass"
        } else {
            binding.textoRecordar.text = "No se esta recordando tu pass"
        }

        Log.v("datos",datosRecuperados?.getString("nombre") ?: "sin datos extra")
        Log.v("datos",datosRecuperados?.getString("correo")?: "sin datos extra")
        Log.v("datos",datosRecuperados?.getString("pass")?: "sin datos extra")
        Log.v("datos",datosRecuperados?.getBoolean("recordar",false).toString() ?: "sin datos extra")
    }
}