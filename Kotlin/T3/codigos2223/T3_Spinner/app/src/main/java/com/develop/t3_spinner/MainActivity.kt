package com.develop.t3_spinner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.develop.t3_spinner.adaptadores.AdaptadorPersonalizado
import com.develop.t3_spinner.databinding.ActivityMainBinding
import com.develop.t3_spinner.modelo.Pais
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    lateinit var binding: ActivityMainBinding;
    lateinit var arraySpinner: ArrayList<Pais>;
    lateinit var adaptadorSencillo: ArrayAdapter<CharSequence>;
    lateinit var adaptadorPersonalizado: AdaptadorPersonalizado;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        instancias()
        asociarDatos()
        rellenarSpinnerPersonalizado()
        acciones()
    }

    private fun acciones() {
        /*binding.spinnerSimple.setOnItemClickListener { adapterView, view, i, l ->
            Snackbar.make(binding.spinnerSimple,i.toString(),Snackbar.LENGTH_SHORT).show()
        }*/

        binding.spinnerSimple.onItemSelectedListener = this;
        binding.spinnerComplejo.onItemSelectedListener = this
        binding.botonAgregar.setOnClickListener {
            var pais = Pais("Argentina", R.drawable.argentina)
            adaptadorPersonalizado.agregarPais(pais)
            //arraySpinner.add(pais)
            //adaptadorPersonalizado.notifyDataSetChanged()
        }
    }

    private fun asociarDatos() {
        binding.spinnerSimple.adapter = adaptadorSencillo;
        binding.spinnerComplejo.adapter = adaptadorPersonalizado
    }

    private fun instancias() {
        arraySpinner = ArrayList()
        //adaptadorSencillo = ArrayAdapter(applicationContext,
        // android.R.layout.simple_spinner_item, arraySpinner)
        adaptadorSencillo = ArrayAdapter.createFromResource(
            applicationContext,
            R.array.paises,
            android.R.layout.simple_spinner_item
        );
        //adaptadorSencillo.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        // lista + xml + context --> adapter
        //rellenarSpinnerPersonalizado()
        adaptadorPersonalizado = AdaptadorPersonalizado(arraySpinner, this)

    }

    private fun rellenarSpinnerPersonalizado() {
        // lista --> array arraylist ó recurso-string
        arraySpinner.add(Pais("España", R.drawable.espania))
        arraySpinner.add(Pais("Brasil", R.drawable.brasil))
        arraySpinner.add(Pais("Alemania", R.drawable.alemania))
        arraySpinner.add(Pais("Francia", R.drawable.francia))
        arraySpinner.add(Pais("Qatar", R.drawable.qatar))
        adaptadorPersonalizado.notifyDataSetChanged()

    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {

        when (p0?.id) {
            R.id.spinner_simple -> {
                Log.v("testSpinner", adaptadorSencillo.getItem(p2).toString())
            }
            R.id.spinner_complejo -> {

                var pais: Pais = adaptadorPersonalizado.getItem(p2) as Pais;
                Log.v("testSpinner", pais.nombre)
            }
        }

        //Snackbar.make(p1!!,p2.toString(),Snackbar.LENGTH_SHORT).show()
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {

    }
}