package com.example.t2_estados

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatTextView
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(), OnClickListener {

    private lateinit var botonIncremento: AppCompatButton
    private lateinit var botonDecremento: AppCompatButton
    private lateinit var textoContador: AppCompatTextView
    private var contador: Int = 0;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        contador = savedInstanceState?.getInt("contador") ?:0
        instancias()
        textoContador.text = contador.toString();
        acciones()
        Log.v("ciclo_vida", "ejecutando metodo onCreate")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("contador",contador)
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

        // cuando llego a 15 pulsaciones
            // aviso: "Limite alcanzado    Resetear"
         // si le doy a resetear-> contador pasa a ser 0


        if (contador<15){
            when (v!!.id) {
                R.id.boton_suma -> {
                    // incrementara contador
                    contador++;
                }
                R.id.boton_resta -> {
                    // decrementara contador
                    contador--;
                }
            }
            textoContador.text = contador.toString()
        }

        comprobarEstado(v!!);

    }

    fun comprobarEstado(view: View): Boolean {

        if (contador==15){
            Snackbar.make(view,"Limite alcanzado",Snackbar.LENGTH_LONG)
                .setAction("Resetear"){
                    contador = 0
                    textoContador.text = contador.toString()
                }
                .show()

            return true
        }

        return false
    }
}