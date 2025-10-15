package com.example.holamundo

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.v("ciclo_vida","Ejecutando metodo OnCreate")
    }

    override fun onRestart() {
        super.onRestart()
        Log.v("ciclo_vida","Ejecutando metodo OnRestart")

    }

    override fun onStart() {
        super.onStart()
        Log.v("ciclo_vida","Ejecutando metodo OnStart")

    }

    override fun onResume() {
        super.onResume()
        Log.v("ciclo_vida","Ejecutando metodo OnResume")

    }

    override fun onPause() {
        super.onPause()
        Log.v("ciclo_vida","Ejecutando metodo OnPause")

    }

    override fun onStop() {
        super.onStop()
        Log.v("ciclo_vida","Ejecutando metodo OnStop")

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.v("ciclo_vida","Ejecutando metodo OnDestroy")

    }

}