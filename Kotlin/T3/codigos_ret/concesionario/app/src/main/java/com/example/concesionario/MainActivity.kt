package com.example.concesionario

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.concesionario.databinding.ActivityMain1Binding
import com.example.concesionario.model.Marca
import com.example.concesionario.ui.ModelosActivity

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMain1Binding
    private lateinit var adapterMarcas: ArrayAdapter<Marca>
    private lateinit var listaMarcas: ArrayList<Marca>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain1Binding.inflate(layoutInflater)
        setContentView(binding.root)
        instancias()
        initGUI()
        acciones()
    }

    private fun acciones() {

        binding.spinnerMarcas.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val marcaSeleccionada: Marca =
                    binding.spinnerMarcas.adapter.getItem(position) as Marca
                binding.imagenMarca.setImageResource(marcaSeleccionada.logo)

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

        }
        binding.botonConsulta.setOnClickListener {
            val intent = Intent(this, ModelosActivity::class.java)
            intent.putExtra("marca",
                binding.spinnerMarcas.selectedItem as Marca)
            startActivity(intent)
        }
    }

    private fun initGUI() {

        binding.spinnerMarcas.adapter = adapterMarcas
        adapterMarcas.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
    }

    private fun instancias() {
        listaMarcas = arrayListOf(
            Marca("Ford", R.drawable.ford),
            Marca("Fiat", R.drawable.fiat),
            Marca("VW", R.drawable.vw),
            Marca("Audi", R.drawable.audi),
            Marca("Mercedes", R.drawable.mercedes)
        )
        adapterMarcas = ArrayAdapter(
            applicationContext,
            android.R.layout.simple_spinner_item,
            listaMarcas
        )
    }
}