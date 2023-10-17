package com.example.t2_estado

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatTextView

class MainActivity : AppCompatActivity(), OnClickListener {

    private lateinit var botonIncremento: AppCompatButton
    private lateinit var botonDecremento: AppCompatButton
    private lateinit var textoContador: AppCompatTextView
    private var contador: Int? = null;

    // juntar parte grafica parte logica
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        instacias()
        acciones()
        Log.v("ciclo_vida", "ejecutado metodo onCreate")
    }

    private fun acciones() {
        botonDecremento.setOnClickListener(this)
        botonIncremento.setOnClickListener(this)
    }

    private fun instacias() {
        contador = 0;
        textoContador = findViewById(R.id.texto_contador)
        botonDecremento = findViewById(R.id.boton_resta)
        botonIncremento = findViewById(R.id.boton_suma)
    }

    override fun onStart() {
        super.onStart()
        Log.v("ciclo_vida", "ejecutado metodo onStart")
    }

    // ultimo metodo justo antes de mostrar la pantalla
    override fun onResume() {
        super.onResume()
        Log.v("ciclo_vida", "ejecutado metodo onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.v("ciclo_vida", "ejecutado metodo onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.v("ciclo_vida", "ejecutado metodo onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.v("ciclo_vida", "ejecutado metodo onDestroy")
    }

    override fun onClick(p0: View?) {
        when (p0!!.id) {
            R.id.boton_suma -> {
                Log.v("contador", "pulsado suma")
                contador = contador!! + 1;
            }

            R.id.boton_resta -> {
                Log.v("contador", "pulsado resta")
                contador = contador!! - 1;
            }
        }

        textoContador.setText(contador.toString())
    }
}