package com.example.ciclos.ui.activities

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.example.ciclos.databinding.ActivityMainBinding
import com.example.ciclos.model.Asignatura
import com.example.ciclos.model.Ciclo

class MainActivity : AppCompatActivity(), OnItemSelectedListener {

    private lateinit var listaCiclo: ArrayList<Ciclo>
    private lateinit var adapterCiclos: ArrayAdapter<Ciclo>
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapterAsignatura: ArrayAdapter<Asignatura>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        instancias();
    }

    override fun onStart() {
        super.onStart()
        iniciarSpinner()
    }

    override fun onResume() {
        super.onResume()
        acciones()
    }

    private fun acciones() {
        binding.spinnerCiclos.onItemSelectedListener = this
        binding.spinnerAsignaturas.onItemSelectedListener = this
    }

    private fun iniciarSpinner() {
        binding.spinnerCiclos.adapter = adapterCiclos
    }

    private fun instancias() {
        var af =
            Ciclo(
                "Administracion y Finanzas",
                "Administracion",
                "AF",
                arrayListOf(
                    Asignatura("Contabilada", "CONT", 5, true),
                    Asignatura("Administracion", "ADMIN", 3, false)
                )
            )
        var asir =
            Ciclo(
                "Administracion de Sistemas",
                "Informatica",
                "ASIR",
                arrayListOf(
                    Asignatura("Sistamas", "SI", 8, true),
                    Asignatura("Base datos", "BD", 6, true),
                )
            )
        var dam = Ciclo(
            "Desarrollo Aplicaciones", "Informatica", "DAM", arrayListOf(
                Asignatura("Programacion", "PRO", 8, true),
                Asignatura("Lenguaje de Marcas", "LM", 4, true),
            )
        )
        listaCiclo = arrayListOf(af, asir, dam);
        adapterCiclos =
            ArrayAdapter(applicationContext, android.R.layout.simple_spinner_item, listaCiclo)
        adapterCiclos.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        // detecto cuando cambia la seleccion
        when (p0?.id) {
            binding.spinnerCiclos.id -> {
                // que ciclo es el seleccionado
                val cicloSeleccionado: Ciclo = adapterCiclos.getItem(p2)!!
                // cual es su lista de asignaturas
                val listaSeleccionada: ArrayList<Asignatura> = cicloSeleccionado.listaAsignaturas!!
                // las pongo en el spinner
                adapterAsignatura = ArrayAdapter(
                    applicationContext,
                    android.R.layout.simple_spinner_item,
                    listaSeleccionada
                )
                adapterAsignatura.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                binding.spinnerAsignaturas.adapter = adapterAsignatura
            }
        }
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        // detecto cuando no cambia la seleccion, pero he desplegado
    }
}