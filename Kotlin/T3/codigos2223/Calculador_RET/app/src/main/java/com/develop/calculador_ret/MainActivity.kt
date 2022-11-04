package com.develop.calculador_ret

import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import com.develop.calculador_ret.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {


    private lateinit var binding: ActivityMainBinding




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view: View = binding.root
        setContentView(view)

        //requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT;
        /*if (resources.configuration.orientation == ActivityInfo.SCREEN_ORIENTATION_PORTRAIT) {
            setContentView(R.layout.activity_main)
        } else if (resources.configuration.orientation == ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE) {
            setContentView(R.layout.activity_warning)
        }*/
        //instancias();
        //acciones();
    }

    private fun acciones() {

        binding.botonUno?.setOnClickListener(this)
        binding.botonDos?.setOnClickListener(this)
        binding.botonTres?.setOnClickListener(this)
        binding.botonCuatro?.setOnClickListener(this)
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
}