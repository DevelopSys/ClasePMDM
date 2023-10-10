package com.example.t2_inicio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    lateinit var boton: Button;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        instancias()
        acciones()


    }

    private fun acciones() {
        boton.setOnClickListener {
            var notificion = Snackbar.make(it, R.string.text_superada, Snackbar.LENGTH_INDEFINITE)
            notificion.setAction(R.string.text_pulsar){
                // ocultar la notificacion
                notificion.dismiss()
            }
            notificion.show()
        }
    }

    private fun instancias() {
        boton = findViewById(R.id.boton_pulsar);
    }
}