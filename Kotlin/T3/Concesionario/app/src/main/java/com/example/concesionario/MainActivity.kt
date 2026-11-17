package com.example.concesionario

import android.os.Binder
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.concesionario.data.DataSet
import com.example.concesionario.databinding.ActivityMainBinding
import com.example.concesionario.model.Marca

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapterMarca: ArrayAdapter<Marca>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        instances()
        actions()
    }

    private fun actions() {
        // binding.spinnerMarca.onItemSelectedListener = this
        binding.spinnerMarca.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                p0: AdapterView<*>?,
                p1: View?,
                p2: Int,
                p3: Long
            ) {
                val marca: Marca = p0!!.adapter.getItem(p2) as Marca
                Log.v("test_spinner", "cambio de seleccion a marca: ${marca.name}")
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                Log.v("test_spinner", "sin cambio cambio")
            }

        }
    }

    private fun instances() {

        adapterMarca = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item,
            DataSet.listMarca
        )
        adapterMarca.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerMarca.adapter = adapterMarca

    }

    /*override fun onItemSelected(
        p0: AdapterView<*>?,
        p1: View?,
        p2: Int,
        p3: Long
    ) {
        TODO("Not yet implemented")
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        TODO("Not yet implemented")
    }*/
}