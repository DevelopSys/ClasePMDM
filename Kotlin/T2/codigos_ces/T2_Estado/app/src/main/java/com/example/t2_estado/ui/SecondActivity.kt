package com.example.t2_estado.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatTextView
import com.example.t2_estado.R

class SecondActivity : AppCompatActivity() {

    private lateinit var textoRepcion: AppCompatTextView
    private var contador: Int =0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        instancias();
        contador = intent.extras?.getInt("contador",7) ?:0
        textoRepcion.setText(contador.toString())
    }

    private fun instancias() {

        textoRepcion = findViewById(R.id.texto_recepcion)
    }
}