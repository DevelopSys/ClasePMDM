package com.example.t2_estado.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatImageButton
import androidx.appcompat.widget.AppCompatTextView
import com.example.t2_estado.R
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(), OnClickListener {

    private lateinit var botonIncremento: AppCompatButton
    private lateinit var botonDecremento: AppCompatButton
    private lateinit var textoContador: AppCompatTextView
    private var botonAdicional: AppCompatImageButton? = null

    private var contador: Int? = null;

    // juntar parte grafica parte logica
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        contador = savedInstanceState?.getInt("contador") ?: 0;

        instancias()
        textoContador.setText(contador.toString())
        acciones()
        Log.v("ciclo_vida", "ejecutado metodo onCreate")
    }

    private fun acciones() {
        botonDecremento.setOnClickListener(this)
        botonIncremento.setOnClickListener(this)
        botonAdicional?.setOnClickListener(this)
        //application.applicationContext. si estoy land -->accion
    }

    private fun instancias() {
        botonAdicional = findViewById(R.id.boton_adicional)
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

        if (contador!! < 15) {
            when (p0!!.id) {
                R.id.boton_suma -> {
                    Log.v("contador", "pulsado suma")
                    contador = contador!! + 1;
                }

                R.id.boton_resta -> {
                    Log.v("contador", "pulsado resta")
                    contador = contador!! - 1;
                }
                R.id.boton_adicional -> {
                    Log.v("contador", "pulsado resta")
                    //contador = 0
                    val intent = Intent(applicationContext, SecondActivity::class.java)
                    //intent.putExtra("contador",contador)
                    startActivity(intent)

                }
            }

        }

        if (!comprobarLimite(p0!!)) {
            textoContador.setText(contador.toString())
        }
    }

    fun comprobarLimite(view: View): Boolean {
        if (contador == 15) {

            Snackbar.make(view, "Limite alcanzado", Snackbar.LENGTH_LONG)
                .setAction("Resetear") {
                    contador = 0
                    textoContador.setText(contador!!.toString())
                }
                .show()

            return true;
        }

        return false
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("contador", contador!!)
    }
}