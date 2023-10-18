package com.example.t2_estados

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView

class SecondActivity : AppCompatActivity() {

    private lateinit var imagen: AppCompatImageView
    private lateinit var textoContador: AppCompatTextView
    private var contador: Int = 0;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val bundle = intent.extras
        contador = bundle?.getInt("contador") ?: 0
        instancias();
        textoContador.text = contador.toString()
        imagen.setImageResource(R.drawable.ejemplo)
    }

    private fun instancias() {
        textoContador = findViewById(R.id.texto_contador_comunicado)
        imagen = findViewById(R.id.imagen);
    }
}