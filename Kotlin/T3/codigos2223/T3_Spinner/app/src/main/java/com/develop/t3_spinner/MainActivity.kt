package com.develop.t3_spinner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.develop.t3_spinner.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    lateinit var binding: ActivityMainBinding;
    lateinit var arraySpinner: ArrayList<String>;
    lateinit var adaptadorSencillo: ArrayAdapter<String>;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        instancias()
        asociarDatos()
        rellenarSpinner()
        acciones()
    }

    private fun acciones() {
        /*binding.spinnerSimple.setOnItemClickListener { adapterView, view, i, l ->
            Snackbar.make(binding.spinnerSimple,i.toString(),Snackbar.LENGTH_SHORT).show()
        }*/


        binding.spinnerSimple.onItemSelectedListener = this;
    }

    private fun asociarDatos() {
        binding.spinnerSimple.adapter = adaptadorSencillo;
    }
    private fun instancias() {
        arraySpinner = ArrayList()
        adaptadorSencillo = ArrayAdapter(applicationContext,android.R.layout.simple_spinner_item,
            arraySpinner)
        adaptadorSencillo.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
    }
    private fun rellenarSpinner() {
        // lista --> array arraylist ó recurso-string
        arraySpinner.add("España")
        arraySpinner.add("Brasil")
        arraySpinner.add("Alemania")
        arraySpinner.add("Francia")
        arraySpinner.add("Qatar")
    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        Log.v("testSpinner", p2.toString())
        //Snackbar.make(p1!!,p2.toString(),Snackbar.LENGTH_SHORT).show()
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        
    }
}