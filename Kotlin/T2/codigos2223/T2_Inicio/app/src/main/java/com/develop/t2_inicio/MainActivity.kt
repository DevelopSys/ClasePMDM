package com.develop.t2_inicio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var botonPulsar: Button
    lateinit var textoSaludo: TextView

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        botonPulsar = findViewById(R.id.boton_pulsar)
        // xml + kt
        Log.v("ciclo_vida","Método onCreate ejecutado")
        textoSaludo = findViewById(R.id.texto_bienvenida);
        /*botonPulsar.setOnClickListener ({
            Log.v("ciclo_vida","Botón pulsado")
            textoSaludo.setText("Primera app completa")
        })*/


    }


}