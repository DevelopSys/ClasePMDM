package com.example.contador

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import com.example.contador.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.v("ciclo_vida","ejecutando OnCreate")
        binding.botonIncrementar.setOnClickListener {

        }


    }

    override fun onStart() {
        super.onStart()
        Log.v("ciclo_vida","ejecutando OnStart")
    }

    override fun onResume() {
        super.onResume()
        Log.v("ciclo_vida","ejecutando onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.v("ciclo_vida","ejecutando onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.v("ciclo_vida","ejecutando onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.v("ciclo_vida","ejecutando onDestroy")
    }
}