package com.develop.t2_inicio_ret

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

class SecondActivity : AppCompatActivity() {

    private lateinit var nombreRecuperado: String
    private var edadRecuperada: Int = 0;
    private lateinit var correoRecuperado: String;

    private lateinit var textoNombre: TextView;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        instancias();
        recuperarDatos();
        iniciarUI()

    }

    private fun instancias() {
        textoNombre = findViewById(R.id.texto_recepcion)
    }

    private fun iniciarUI() {
        Log.v("datos_recuperado", nombreRecuperado)
        Log.v("datos_recuperado", correoRecuperado)
        Log.v("datos_recuperado", edadRecuperada.toString())
        textoNombre.setText(nombreRecuperado+ resources.getString(R.string.saludo_completo))
    }

    private fun recuperarDatos() {
        nombreRecuperado = intent.extras?.getString("nombre","defecto")
            ?: "defecto null bundle";
        edadRecuperada = intent.extras?.getInt("edad",16) ?: 0;
        correoRecuperado = intent.extras?.getString("correo","correo@defecto.com")
            ?: "sin correo"
    }
}