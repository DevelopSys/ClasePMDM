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
import com.example.concesionario.adapter.AdaptadorMarca
import com.example.concesionario.adapter.AdaptadorModelo
import com.example.concesionario.databinding.ActivityMainBinding
import com.example.concesionario.model.Marca
import com.example.concesionario.model.Modelo
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    // lista de datos a representar
    private lateinit var listaMarcas: ArrayList<Marca>
    // adaptador de datos
    // private lateinit var adaptadorMarcas: ArrayAdapter<Marca>
    private lateinit var adaptadorMarca: AdaptadorMarca

    private lateinit var listaModelos: ArrayList<Modelo>
    private lateinit var adaptadorModelos: AdaptadorModelo


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
            Marca("Selecciona marca",0),
            Marca("Mercedes",R.drawable.mercedes),
            Marca("Audi",R.drawable.audi),
            Marca("Ford",R.drawable.ford),
            Marca("BMW",R.drawable.bmw),
            Marca("BYD",R.drawable.byd),
        )
        adaptadorMarca = AdaptadorMarca(listaMarcas, applicationContext)
        binding.spinnerMarcas.adapter = adaptadorMarca

        listaModelos = arrayListOf(
            Modelo("Mercedes","C63",R.drawable.c63),
            Modelo("Mercedes","S63",R.drawable.s63),
            Modelo("Audi","RS7",R.drawable.rs7),
            Modelo("Audi","RS5",R.drawable.rs5),
            Modelo("BMW","M3",R.drawable.m3),
            Modelo("BMW","M4",R.drawable.m4),
            Modelo("Ford","Mustang GT",R.drawable.mustangt),
        )
        adaptadorModelos = AdaptadorModelo(listaModelos,applicationContext)
        binding.listaModelos.adapter = adaptadorModelos
        //listaMarcas.add(Marca("Peugeot",R.drawable.peugeot))
        /*adaptadorMarcas = ArrayAdapter(applicationContext,
            android.R.layout.simple_spinner_item,listaMarcas)
        adaptadorMarcas.setDropDownViewResource(android.R.layout
            .simple_spinner_dropdown_item)

        binding.spinnerMarcas.adapter = adaptadorMarcas*/
    }

    private fun acciones() {
        binding.btnFiltrar.setOnClickListener {
            //val seleccionMarca: String = binding.spinnerMarcas.selectedItem.toString()
            listaMarcas.add(Marca("Opel",R.drawable.bmw))
            //adaptadorMarcas.notifyDataSetChanged()
            if (binding.spinnerMarcas.selectedItemPosition != 0) {
                /*Snackbar.make(
                    binding.root,
                    "La marca seleccionada es $seleccionMarca",
                    Snackbar.LENGTH_SHORT
                ).show()*/
            }

        }
        binding.spinnerMarcas.onItemSelectedListener = object : OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                if (p2!=0){

                    val listaFiltrada = listaModelos.filter { it.marca == (adaptadorMarca.getItem(p2) as Marca).nombre } as ArrayList
                    adaptadorModelos.cambiarLista(listaFiltrada)
                    //val marcaSeleccionada: Marca = adaptadorMarcas.getItem(p2) as Marca
                    // binding.imagenLogo.setImageResource(marcaSeleccionada.imagen)
                    //
                //
                // binding.spinnerMarcas.setSelection(0)
                }

            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

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