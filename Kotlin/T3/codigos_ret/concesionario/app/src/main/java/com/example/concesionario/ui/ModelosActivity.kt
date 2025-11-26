package com.example.concesionario.ui

import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import android.view.View
import android.widget.AdapterView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.concesionario.R
import com.example.concesionario.adapter.AdapterCoche
import com.example.concesionario.adapter.AdapterModelo
import com.example.concesionario.databinding.ActivityModelosBinding
import com.example.concesionario.dataset.DataSet
import com.example.concesionario.model.Coche
import com.example.concesionario.model.Marca
import com.example.concesionario.model.Modelo

class ModelosActivity : AppCompatActivity() {

    private lateinit var binding: ActivityModelosBinding
    private lateinit var marca: Marca
    private lateinit var adapterModelo: AdapterModelo
    private lateinit var listaModelos: ArrayList<Modelo>
    private lateinit var adapterCoche: AdapterCoche
    private lateinit var listaCoches: ArrayList<Coche>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityModelosBinding.inflate(layoutInflater)
        setContentView(binding.root)
        marca = intent.getSerializableExtra("marca") as Marca
        instancias()
        initGUI()
        acciones()
        // binding.textoModelos.append(" ${marca.nombre}")
        binding.textoModelos.append(" ${marca.nombre}")

    }

    private fun acciones() {



        binding.spinnerModelos.onItemSelectedListener = object : AdapterView.OnItemSelectedListener
        {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val modeloSeleccionado: Modelo = parent!!.adapter.getItem(position) as Modelo
                listaCoches = DataSet.getModelos(modeloSeleccionado);
                adapterCoche = AdapterCoche(listaCoches,applicationContext)
                binding.listaCoches.adapter = adapterCoche
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

        }
    }

    private fun initGUI() {
        binding.spinnerModelos.adapter = adapterModelo;
        binding.listaCoches.layoutManager =
            LinearLayoutManager(
                this,
                LinearLayoutManager.VERTICAL,
                false
            )
        binding.listaCoches.adapter = adapterCoche
    }

    private fun instancias() {

        listaModelos = DataSet.getListaModelos(marca)
        adapterModelo = AdapterModelo(listaModelos)
        listaCoches =
            DataSet.getModelos(Modelo(Marca("Ford", 1), "Fiesta"))

        adapterCoche = AdapterCoche(listaCoches, this)


    }
}