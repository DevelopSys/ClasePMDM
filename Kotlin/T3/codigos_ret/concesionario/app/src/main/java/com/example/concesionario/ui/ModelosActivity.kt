package com.example.concesionario.ui

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.concesionario.R
import com.example.concesionario.adapter.AdapterModelo
import com.example.concesionario.databinding.ActivityModelosBinding
import com.example.concesionario.model.Marca
import com.example.concesionario.model.Modelo

class ModelosActivity : AppCompatActivity() {

    private lateinit var binding: ActivityModelosBinding
    private lateinit var marca: Marca
    private lateinit var adapterModelo: AdapterModelo
    private lateinit var listaModelos: ArrayList<Modelo>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityModelosBinding.inflate(layoutInflater)
        setContentView(binding.root)
        marca = intent.getSerializableExtra("marca") as Marca
        instancias()
        initGUI()
        // binding.textoModelos.append(" ${marca.nombre}")
        binding.textoModelos.append(" ${marca.nombre}")

    }

    private fun initGUI() {
        binding.spinnerModelos.adapter = adapterModelo;
    }

    private fun instancias() {
        listaModelos = arrayListOf(
            Modelo(marca, "Modelo1", 10000, 100, R.drawable.vw, ""),
            Modelo(marca, "Modelo2", 20000, 200, R.drawable.fiat, ""),
            Modelo(marca, "Modelo3", 30000, 300, R.drawable.ford, ""),
            Modelo(marca, "Modelo4", 40000, 400, R.drawable.audi, ""),
            Modelo(marca, "Modelo5", 50000, 500, R.drawable.mercedes, ""),
        )
        adapterModelo = AdapterModelo(listaModelos)

    }
}