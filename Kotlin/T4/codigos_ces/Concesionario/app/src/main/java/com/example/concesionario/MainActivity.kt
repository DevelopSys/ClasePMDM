package com.example.concesionario

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.concesionario.databinding.ActivityMainBinding
import com.example.concesionario.model.Marca
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    // lista de datos a representar
    private lateinit var listaMarcas: ArrayList<Marca>
    // adaptador de datos
    private lateinit var adaptadorMarcas: ArrayAdapter<Marca>


    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        instancias()

        acciones()

    }

    private fun instancias() {
        listaMarcas = arrayListOf(
            Marca("Mercedes",R.drawable.mercedes),
            Marca("Audi",R.drawable.audi),
            Marca("Ford",R.drawable.ford),
            Marca("BMW",R.drawable.bmw),
            Marca("BYD",R.drawable.byd),
        )
        listaMarcas.add(Marca("Peugeot",R.drawable.peugeot))

        adaptadorMarcas = ArrayAdapter(applicationContext,
            android.R.layout.simple_spinner_item,listaMarcas)
        adaptadorMarcas.setDropDownViewResource(android.R.layout
            .simple_spinner_dropdown_item)

        binding.spinnerMarcas.adapter = adaptadorMarcas
    }

    private fun acciones() {
        binding.btnFiltrar.setOnClickListener {
            //val seleccionMarca: String = binding.spinnerMarcas.selectedItem.toString()
            if (binding.spinnerMarcas.selectedItemPosition != 0) {
                /*Snackbar.make(
                    binding.root,
                    "La marca seleccionada es $seleccionMarca",
                    Snackbar.LENGTH_SHORT
                ).show()*/
            }

        }
        /*binding.spinnerMarcas.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                if (p2 != 0) {
                    val seleccionMarca = binding.spinnerMarcas.adapter.getItem(p2).toString()
                    Snackbar.make(
                        binding.root,
                        "La marca seleccionada es ${seleccionMarca}",
                        Snackbar.LENGTH_SHORT
                    ).show()
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }

        }*/

    }
}