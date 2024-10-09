package com.example.contador

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.TextView
import com.example.contador.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), OnClickListener {

    private lateinit var binding: ActivityMainBinding
    private var contador: Int = 0;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // savedInstanceState.getInt()
        // recuperar estado

        contador = savedInstanceState?.getInt("contador",0)?:0
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.textoContador.text = contador.toString();
        Log.v("ciclo_vida", "ejecutando OnCreate")
        binding.botonIncrementar.setOnClickListener(this)
        binding.botonDecrementar.setOnClickListener(this)


    }

    override fun onStart() {
        super.onStart()
        Log.v("ciclo_vida", "ejecutando OnStart")
    }

    override fun onResume() {
        super.onResume()
        Log.v("ciclo_vida", "ejecutando onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.v("ciclo_vida", "ejecutando onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.v("ciclo_vida", "ejecutando onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.v("ciclo_vida", "ejecutando onDestroy")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("contador", contador)
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            binding.botonIncrementar.id -> {
                contador++
            }

            binding.botonDecrementar.id -> {
                contador--
            }
        }
        binding.textoContador.text = contador.toString()
    }
}