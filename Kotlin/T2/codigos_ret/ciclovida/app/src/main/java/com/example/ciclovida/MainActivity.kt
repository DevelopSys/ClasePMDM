package com.example.ciclovida

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.TextView
import com.example.ciclovida.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), OnClickListener {

    /*private lateinit var botonIncremento: Button;
    private lateinit var botonDecremento: Button;
    private lateinit var textoContador: TextView;*/
    private lateinit var binding: ActivityMainBinding
    private var contador = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.v("ciclo_vida", "Ejecutando onCreate")
        instancias()
        acciones()
    }

    private fun acciones() {

        binding.botonIncremento.setOnClickListener(this)
        binding.botonDecremento.setOnClickListener(this)

        /*binding.botonIncremento.setOnClickListener {
            // si pulso el boton +, se suma 1 al texto
            contador++
            binding.textoContador.text = contador.toString()
        }
        binding.botonDecremento.setOnClickListener {
            // si pulso el boton -, se resta 1 al texto
            contador--
            binding.textoContador.text = contador.toString()
        }*/

    }

    override fun onClick(v: View?) {
        when(v!!.id){
            binding.botonIncremento.id->{
                contador++
            }
            binding.botonDecremento.id->{
                contador--
            }
        }
        binding.textoContador.text = contador.toString()
    }

    private fun instancias() {
        //botonDecremento = findViewById(R.id.botonDecremento)
        //botonIncremento = findViewById(R.id.botonIncremento)
        //textoContador = findViewById(R.id.textoContador)
    }

    override fun onStart() {
        super.onStart()
        Log.v("ciclo_vida", "Ejecutando onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.v("ciclo_vida", "Ejecutando onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.v("ciclo_vida", "Ejecutando onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.v("ciclo_vida", "Ejecutando onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.v("ciclo_vida", "Ejecutando onDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        Log.v("ciclo_vida", "Ejecutando onRestart")
    }


}