package com.develop.t3_spinner_ret

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.develop.t3_spinner_ret.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adaptadorSimple: ArrayAdapter<String>
    private lateinit var arrayDatos: ArrayList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // parte grafica binding.spinnerSimple
        // parte logica --> lista de datos (Array - ArrayList ó un recurso),
        //                  vista gráfica --> android.R.layout.simple_spinner_item_1
        //                  contexto --> getApplicationContext
        instancias()
        asociarDatos()
        rellenarLista();
        acciones()
    }

    private fun acciones() {
        binding.spinnerSimple.onItemSelectedListener = this
        binding.botonAgregar.setOnClickListener {
            arrayDatos.add("Dato nuevo")
            adaptadorSimple.notifyDataSetChanged()
        }
    }


    private fun rellenarLista() {
        arrayDatos.add("Elemento uno")
        arrayDatos.add("Elemento dos")
        arrayDatos.add("Elemento tres")
        arrayDatos.add("Elemento cuatro")
        adaptadorSimple.notifyDataSetChanged()
    }

    private fun asociarDatos() {

        binding.spinnerSimple.adapter = adaptadorSimple
    }

    private fun instancias() {
        arrayDatos = ArrayList();
        adaptadorSimple = ArrayAdapter(applicationContext,
            android.R.layout.simple_spinner_item, arrayDatos)
        adaptadorSimple.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        /*adaptadorSimple = ArrayAdapter.createFromResource(
            applicationContext, R.array.array_recurso, android.R.layout.simple_spinner_item
        )*/
    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        // p0 --> vista del evento
        // p1 --> la fila que se ha pulsado
        // p2 --> la posicion pulsada 0...n
        // p3 --> id (pk): id --> posicion
        Snackbar.make(binding.spinnerSimple, adaptadorSimple.getItem(p2) ?: "No hay datos", Snackbar.LENGTH_SHORT)
            .show()
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {

    }
}