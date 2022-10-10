package com.develop.t2_inicio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var botonPulsar: Button
    lateinit var textoSaludo: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // xml + kt
        botonPulsar = findViewById(R.id.boton_pulsar)
        textoSaludo = findViewById(R.id.texto_bienvenida);

        botonPulsar.setOnClickListener ({
            textoSaludo.setText("Primera app completa")
        })

        // cuando pulse el boton que ponga un texto en el textview


    }


}