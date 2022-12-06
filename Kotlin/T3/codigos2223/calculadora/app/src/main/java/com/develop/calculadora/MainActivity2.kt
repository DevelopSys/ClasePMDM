package com.develop.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.develop.calculadora.R

class MainActivity2 : AppCompatActivity() {

    var nombre = "Borja"
    val edad = 29.6;
    lateinit var boton: Button;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
    }
}