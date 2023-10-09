package com.example.t2estructura

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var boton: Button;
    private lateinit var editNombre: EditText;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        instancias()
        acciones()
    }

    private fun acciones() {
        // setOnAction()
        boton.setOnClickListener {
            // el texto no deberia ir aqui
            // si hay texto, lo capturas y lo pones en la noticicion
            // si no hay texto saltas un aviso
            val notificacion = Snackbar.make(it, R.string.texto_saludo, Snackbar.LENGTH_INDEFINITE)
            notificacion.setAction("ok") {
                notificacion.dismiss()
            }
            notificacion.show()
        }
    }

    private fun instancias() {
        boton = findViewById(R.id.boton_pulsar)
        editNombre = findViewById(R.id.edit_nombre)
    }

}