package com.example.wordces

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.wordces.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(), OnClickListener {

    private lateinit var binding: ActivityMainBinding
    private var listaPalabras = arrayOf("cosas","array","debug")
    private lateinit var palabra: String
    private lateinit var letrasPalabra: Array<Char>
    private var intentos = 5
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        acciones()
    }

    private fun acciones() {
        binding.btnEmpezar.setOnClickListener(this)
        binding.btnValidar.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            binding.btnEmpezar.id ->{
                if (binding.editNombre.text.isNotEmpty()){
                    palabra = listaPalabras.random()
                    palabra = "debug"
                    letrasPalabra = palabra.toCharArray() as Array<Char>
                    Log.v("palabra",palabra)
                }
            }
            binding.btnValidar.id ->{
                intentos--;
                if (binding.editChar1.text.toString()
                    .equals(listaPalabras[0].toString(),true)){
                    binding.editChar1.setBackgroundColor(Color.GREEN)
                }
                if (binding.editChar2.text.toString()
                        .equals(listaPalabras[1].toString(),true)){
                    binding.editChar2.setBackgroundColor(Color.GREEN)
                }
                if (binding.editChar2.text.toString()
                        .equals(listaPalabras[1].toString(),true)){
                    binding.editChar2.setBackgroundColor(Color.GREEN)
                }
                if (binding.editChar2.text.toString()
                        .equals(listaPalabras[1].toString(),true)){
                    binding.editChar2.setBackgroundColor(Color.GREEN)
                }
                if (binding.editChar2.text.toString()
                        .equals(listaPalabras[1].toString(),true)){
                    binding.editChar2.setBackgroundColor(Color.GREEN)
                }

                if (intentos ==0){
                    Snackbar.make(binding.root, "${resources.getString(R.string.aviso)} ${binding.editNombre.text.toString()}", Snackbar.LENGTH_SHORT)
                }
            }
        }
    }
}