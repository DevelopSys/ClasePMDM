package com.example.concesionario

import android.os.Binder
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.concesionario.adapter.ModelAdapter
import com.example.concesionario.data.DataSet
import com.example.concesionario.databinding.ActivityMainBinding
import com.example.concesionario.model.Marca
import com.example.concesionario.model.Model
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(), ModelAdapter.OnModelSelectedListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapterMarca: ArrayAdapter<Marca>
    private lateinit var adapterModel: ModelAdapter
    private var model1: Model? = null;
    private var model2: Model? = null;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        instances()
        initGUI()
        actions()
    }

    private fun initGUI() {
        binding.recyclerModels.adapter = adapterModel
        binding.recyclerModels.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, true)
        // GridLayoutManager(this,2, LinearLayoutManager.VERTICAL, false)
    }

    private fun actions() {
        // binding.spinnerMarca.onItemSelectedListener = this
        binding.spinnerMarca.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                p0: AdapterView<*>?,
                p1: View?,
                p2: Int,
                p3: Long
            ) {
                val marca: Marca = p0!!.adapter.getItem(p2) as Marca
                // Log.v("test_spinner", "cambio de seleccion a marca: ${marca.name}")
                // marca.models
                adapterModel.setListModels(marca.models)
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                Log.v("test_spinner", "sin cambio cambio")
            }

        }

    }

    private fun instances() {

        adapterMarca = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item,
            DataSet.listMarca
        )
        adapterMarca.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerMarca.adapter = adapterMarca

        adapterModel = ModelAdapter(DataSet.listModel, this)

    }

    override fun onModelSelected(model: Model) {
        Snackbar.make(
            binding.root,
            "Modelo desde Activity ${model.name}", Snackbar.LENGTH_LONG
        )
            .show()
    }

    /*override fun onItemSelected(
        p0: AdapterView<*>?,
        p1: View?,
        p2: Int,
        p3: Long
    ) {
        TODO("Not yet implemented")
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        TODO("Not yet implemented")
    }*/
}