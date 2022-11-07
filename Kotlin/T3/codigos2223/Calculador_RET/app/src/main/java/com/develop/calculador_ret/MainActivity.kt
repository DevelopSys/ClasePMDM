package com.develop.calculador_ret

import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.*
import androidx.core.widget.addTextChangedListener
import com.develop.calculador_ret.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener, TextWatcher {


    private lateinit var binding: ActivityMainBinding
    private lateinit var frameEjemplo: ImageButton;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view: View = binding.root
        setContentView(view)

        //        frameEjemplo = findViewById(R.id.boton_uno_uno);
        //        binding.editNumeros.append(frameEjemplo.tag as String);

        //requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT;
        /*if (resources.configuration.orientation == ActivityInfo.SCREEN_ORIENTATION_PORTRAIT) {
            setContentView(R.layout.activity_main)
        } else if (resources.configuration.orientation == ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE) {
            setContentView(R.layout.activity_warning)
        }*/
        //instancias();
        acciones();
    }

    private fun acciones() {

        binding.botonUno?.setOnClickListener(this)
        binding.botonDos?.setOnClickListener(this)
        binding.botonTres?.setOnClickListener(this)
        binding.botonCuatro?.setOnClickListener(this)
        /*binding.editNumeros.addTextChangedListener { editable ->
            run {
                Log.v(
                    "texto",
                    editable.toString()
                )
            }
        }*/
        binding.editNumeros.addTextChangedListener(this)

        //binding.editNumeros.addText

    }

    /*private fun instancias() {
        botonUno = findViewById(R.id.boton_uno)
        botonDos = findViewById(R.id.boton_dos)
        botonTres = findViewById(R.id.boton_tres)
        botonCuatro = findViewById(R.id.boton_cuatro)
        editNumeros = findViewById(R.id.edit_numeros)
    }*/

    override fun onClick(p0: View?) {

        binding.editNumeros.append((p0 as Button).text)
        /*when(p0!!.id){
                R.id.boton_uno->{
                    editNumeros.append("1")
                }
                R.id.boton_dos->{
                    editNumeros.append("2")
                }
                R.id.boton_tres->{
                    editNumeros.append("3")
                }
                R.id.boton_cuatro->{
                    editNumeros.append("4")
                }
            }*/
    }

    override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        Log.v("texto", p0.toString())
        
    }

    override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

    }

    override fun afterTextChanged(p0: Editable?) {

    }
}