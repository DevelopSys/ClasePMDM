package com.develop.t2_inicio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var botonPulsar: Button
    lateinit var textoSaludo: TextView
    lateinit var editNombre: EditText;

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // xml + kt
        Log.v("ciclo_vida", "Método onCreate ejecutado")
        botonPulsar = findViewById(R.id.boton_pulsar)
        textoSaludo = findViewById(R.id.texto_bienvenida);
        editNombre = findViewById(R.id.edit_nombre);

        // parametro onClick -> View el elemento que provoca el evento
        botonPulsar.setOnClickListener({ view: View ->

            if (!editNombre.text.isEmpty()){
                var texto = editNombre.text;
                textoSaludo.setText(texto)
                editNombre.setText("")
            } else {
                Log.v("avisos", "texto introducido vacío")
            }

        })

    }

    override fun onStart() {
        super.onStart()
        Log.v("ciclo_vida", "Método onStart ejecutado")

    }

    override fun onResume() {
        super.onResume()
        Log.v("ciclo_vida", "Método onResume ejecutado")

    }

    override fun onRestart() {
        super.onRestart()
        Log.v("ciclo_vida", "Método onRestart ejecutado")

    }

    override fun onPause() {
        super.onPause()
        Log.v("ciclo_vida", "Método onPause ejecutado")

    }

    override fun onStop() {
        super.onStop()
        Log.v("ciclo_vida", "Método onStop ejecutado")

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.v("ciclo_vida", "Método onDestroy ejecutado")

    }


}