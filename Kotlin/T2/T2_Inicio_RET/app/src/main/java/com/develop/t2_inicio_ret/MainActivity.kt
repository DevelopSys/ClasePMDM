package com.develop.t2_inicio_ret

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var botonInicial: Button;
    lateinit var etiquetaSaludo: TextView;

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        // asocia la parte lógica y la gráfica
        this.setContentView(R.layout.activity_main)
        instancias();
        acciones();
    }

    private fun acciones() {
        botonInicial.setOnClickListener({
            etiquetaSaludo.setText("Hola, primera app completa")
        })
    }

    private fun instancias() {
        this.botonInicial = findViewById(R.id.boton_inicial)
        this.etiquetaSaludo = findViewById(R.id.texto_saludo);
    }
}