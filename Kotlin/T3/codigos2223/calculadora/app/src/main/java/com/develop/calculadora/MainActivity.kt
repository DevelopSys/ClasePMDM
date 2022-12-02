package com.develop.calculadora

import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import com.develop.calculadora.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view: View = binding.root
        setContentView(view)
        acciones()
    }


    private fun acciones() {
        binding.botonUno .setOnClickListener(this)
        binding.botonDos.setOnClickListener(this)
        binding.botonTres?.setOnClickListener(this)
        binding.botonCuatro?.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when (p0!!.id) {
            R.id.boton_uno -> {
                binding.editNumeros.append((p0 as Button).text)
            }
            R.id.boton_dos -> {
                binding.editNumeros.append((p0 as Button).text)
            }
            R.id.boton_tres -> {
                binding.editNumeros.append((p0 as Button).text)
            }
            R.id.boton_cuatro -> {
                binding.editNumeros.append((p0 as Button).text)
            }
        }
    }
}