package com.example.concesionario

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.concesionario.databinding.ActivityMainBinding
import com.example.concesionario.model.Marca
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    lateinit var binding: ActivityMainBinding
    lateinit var listaMarcas: ArrayList<Marca>
    lateinit var adapterMarcas: ArrayAdapter<Marca>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        instancias()
        initGUI()
        acciones()
    }

    private fun initGUI() {

        binding.spinnerMarcas.adapter = adapterMarcas
        adapterMarcas.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
    }

    private fun instancias() {

        listaMarcas =
            arrayListOf(
                Marca("Ford", R.drawable.ford),
                Marca("Opel", R.drawable.opel),
                Marca("Mercedes", R.drawable.mercedes),
                Marca("Fiat", R.drawable.fiat)
            )
        adapterMarcas =
            ArrayAdapter(this, android.R.layout.simple_spinner_item, listaMarcas)
    }

    private fun acciones() {

        binding.botonFiltrar.setOnClickListener {
            Snackbar.make(
                it,
                "La seleccion del spinner de vehiculos es " +
                        "${binding.spinnerMarcas.adapter.getItem(binding.spinnerMarcas.selectedItemPosition)}",
                Snackbar.LENGTH_SHORT
            ).show()
        }
        binding.spinnerVehiculos.onItemSelectedListener = this
        binding.spinnerMarcas.onItemSelectedListener = this
    }

    override fun onItemSelected(
        parent: AdapterView<*>?, view: View?, position: Int, id: Long
    ) {

        when (parent?.id) {
            binding.spinnerVehiculos.id -> {/*
                Snackbar.make(
                    view!!,
                    "La seleccion del spinner de vehiculos es ${binding.spinnerVehiculos.selectedItem.toString()}",
                    Snackbar.LENGTH_SHORT
                ).show()

                 */

                Snackbar.make(
                    view!!,
                    "La seleccion del spinner de vehiculos es ${parent.adapter.getItem(position)}",
                    Snackbar.LENGTH_SHORT
                ).show()
            }

            binding.spinnerMarcas.id -> {
                Snackbar.make(
                    view!!,
                    "La seleccion del spinner de vehiculos es ${
                        (binding.spinnerMarcas.adapter.getItem(
                            position
                        ) as Marca).nombre
                    }",
                    Snackbar.LENGTH_SHORT
                ).show()
            }
        }

    }

    override fun onNothingSelected(parent: AdapterView<*>?) {

    }
}