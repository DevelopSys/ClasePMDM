package com.example.concesionario

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.concesionario.adapter.AdaptadorMarcas
import com.example.concesionario.databinding.ActivityMainBinding
import com.example.concesionario.model.Marca
import com.example.concesionario.model.Modelo
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    // arraylist -> datos a mostrar
    private lateinit var listaMarca: ArrayList<Marca>

    // adapter -> elemento que acompla los datos al spinner
    private lateinit var adaptadorMarcas: AdaptadorMarcas

    // arrayList -> datos a mostrar
    private lateinit var listaModelos: ArrayList<Modelo>
    // adapter -> elemento que acompla los datos al spinner

    private lateinit var binding: ActivityMainBinding;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        instancias()

    }

    private fun instancias() {
        listaModelos = arrayListOf(
            Modelo("Mercedes", "AMG C63", 430000.0, 300, R.drawable.c63),
            Modelo("Mercedes", "AMG S63", 530000.0, 400, R.drawable.s63),
            Modelo("Audi", "RS7", 330000.0, 400, R.drawable.rs7),
            Modelo("Audi", "RS5", 230000.0, 300, R.drawable.rs5),
            Modelo("Ford", "Mustang", 130000.0, 250, R.drawable.mustangt),
            Modelo("Ford", "Mustang Match e", 130000.0, 250, R.drawable.mustangmatch),
            Modelo("BYD", "Seal", 50000.0, 250, R.drawable.seal)
        )
        listaMarca = arrayListOf(
            Marca("Mercedes", R.drawable.mercedes),
            Marca("Audi", R.drawable.audi),
            Marca("BMW", R.drawable.bmw),
            Marca("BYD", R.drawable.byd),
            Marca("Ford", R.drawable.ford),
        )
        adaptadorMarcas = AdaptadorMarcas(listaMarca, applicationContext)
        binding.spinnerMarcas.adapter = adaptadorMarcas
    }
}