package com.example.t2_estados

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatTextView

class MainActivity : AppCompatActivity(), OnClickListener {

    private lateinit var botonIncremento: AppCompatButton
    private lateinit var botonDecremento: AppCompatButton
    private lateinit var textoContador: AppCompatTextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        instancias()
        acciones()
        Log.v("ciclo_vida", "ejecutando metodo onCreate")
    }

    private fun acciones() {
        botonIncremento.setOnClickListener(this)
        botonDecremento.setOnClickListener(this)
    }

    private fun instancias() {
        botonIncremento = findViewById(R.id.boton_suma)
        botonDecremento = findViewById(R.id.boton_resta)
        textoContador = findViewById(R.id.texto_contador)
    }

    override fun onStart() {
        super.onStart()
        Log.v("ciclo_vida", "ejecutando metodo onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.v("ciclo_vida", "ejecutando metodo onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.v("ciclo_vida", "ejecutando metodo onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.v("ciclo_vida", "ejecutando metodo onStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.v("ciclo_vida", "ejecutando metodo onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.v("ciclo_vida", "ejecutando metodo onDestroy")
    }

    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.boton_suma->{
                // incrementara contador
            }
            R.id.boton_resta->{
                // decrementara contador
            }
        }
    }


}