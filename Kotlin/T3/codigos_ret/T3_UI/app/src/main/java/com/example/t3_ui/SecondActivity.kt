package com.example.t3_ui

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import com.example.t3_ui.databinding.ActivitySecondBinding
import com.example.t3_ui.model.Usuario

class SecondActivity : AppCompatActivity() {


    private var usuario: Usuario? = null;
    // inicializo los textViews????
    private lateinit var binding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        usuario = intent.extras?.getSerializable("objeto" ) as Usuario?
        binding.textoNombre.text = usuario?.nombre
        binding.textoPass.text = usuario?.pass
        binding.textoPeriodo.text = usuario?.periodo
        binding.textoTipo.text = usuario?.perfil

    }
}