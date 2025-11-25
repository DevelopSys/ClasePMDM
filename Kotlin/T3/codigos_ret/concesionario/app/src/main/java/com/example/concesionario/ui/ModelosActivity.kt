package com.example.concesionario.ui

import android.os.Bundle
import android.provider.ContactsContract
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
        // binding.textoModelos.append(" ${marca.nombre}")
        binding.textoModelos.append(" ${marca.nombre}")

    }

    private fun initGUI() {
        binding.spinnerModelos.adapter = adapterModelo;
        binding.listaCoches.layoutManager =
            LinearLayoutManager(
                this,
                LinearLayoutManager.HORIZONTAL,
                false
            )
        binding.listaCoches.adapter = adapterCoche
    }

    private fun instancias() {

        listaModelos = DataSet.getListaModelos(marca)
        adapterModelo = AdapterModelo(listaModelos)
        listaCoches = arrayListOf(
            Coche(
                Marca("Ford", R.drawable.ford),
                "Fiesta",
                20000,
                100,
                R.drawable.fiesta,
                "este detalle es del focus"
            ),
            Coche(
                Marca("Ford", R.drawable.ford),
                "Focus",
                10000,
                100,
                R.drawable.focus,
                "este detalle es del focus"
            ),
            Coche(
                Marca("Ford", R.drawable.ford),
                "Mondeo",
                10000,
                100,
                R.drawable.mondeo,
                "este detalle es del focus"
            )
        )
        adapterCoche = AdapterCoche(listaCoches, this)


    }
}