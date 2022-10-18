package com.develop.t2_inicio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView

class SecondActivity : AppCompatActivity() {

    lateinit var textoNombre: TextView;
    lateinit var imagenAndroid: ImageView;
    lateinit var nombreRecuperado: String;
    var edadRecuperada: Int = 0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        // TextView
        instacias()
        recuperarDatos()
        iniciarUI()
    }

    private fun iniciarUI() {
        // textoNombre lo recuperado del Bundle
        textoNombre.setText(nombreRecuperado+ resources.getString(R.string.saludo_recuperado));
        imagenAndroid.setImageResource(R.drawable.android2)
        //imagenAndroid.setImageDrawable(resources.getDrawable(R.drawable.android2))
        Log.v("datos_recuperados",edadRecuperada.toString())

    }

    private fun recuperarDatos() {
        var bundleRecuperado: Bundle? = intent.extras;
        nombreRecuperado = bundleRecuperado?.getString("nombre","por defecto").toString()
        edadRecuperada = bundleRecuperado?.getInt("edad",18) ?: 0

        Log.v("datos_recuperados",nombreRecuperado)
        Log.v("datos_recuperados",edadRecuperada.toString())

    }

    private fun instacias() {
        textoNombre = findViewById(R.id.texto_nombre)
        imagenAndroid = findViewById(R.id.imagen_android)
    }
}