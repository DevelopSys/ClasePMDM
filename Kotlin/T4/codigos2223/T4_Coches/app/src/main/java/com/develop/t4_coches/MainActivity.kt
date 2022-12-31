package com.develop.t4_coches

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.develop.t4_coches.adaptapters.AdapterCoche
import com.develop.t4_coches.databinding.ActivityMainBinding
import com.develop.t4_coches.model.Coche
import com.google.android.material.snackbar.Snackbar


// TODO 3. IMPLEMENTO la interfaz --> escribiendo los metodos de comunicacion

class MainActivity : AppCompatActivity(), OnItemSelectedListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var coches: ArrayList<Coche>
    private lateinit var adapterCoche: AdapterCoche
    private lateinit var precio: String
    private lateinit var marca: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // TODO 5. Utilizo el dato comunicado como me interese en el metodo implementado --> coche comunicado


        if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            // si el movil está en port --> LINEAR

        } else if (resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {

            // si el movil está en land --> GRID (2)
        }

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        coches = ArrayList();

        coches.add(Coche("Mercedes", "AMG GT", 500, 200000, "Deportivo", R.drawable.amggt))
        coches.add(
            Coche(
                "Bentley",
                "Continental",
                400,
                300000,
                "Berlina deportivo",
                R.drawable.continental
            )
        )
        coches.add(Coche("Jaguar", "FType", 300, 150000, "Deportivo", R.drawable.ftype))
        coches.add(Coche("Ford", "GT40", 500, 300000, "Deportivo clasico", R.drawable.gt40))
        coches.add(Coche("Nissan", "GTR", 300, 200000, "Deportivo", R.drawable.gtr))
        coches.add(Coche("Porche", "Huayara", 600, 400000, "Deportivo", R.drawable.huayra))
        coches.add(Coche("Lexus", "LC", 200, 100000, "Deportivo", R.drawable.lc))
        coches.add(Coche("Ferrari", "Le ferrari", 600, 600000, "Deportivo", R.drawable.leferrari))
        coches.add(Coche("McLaren", "MC600", 500, 450000, "Deportivo", R.drawable.mc600))
        coches.add(Coche("Toyota", "Supra", 300, 150000, "Deportivo", R.drawable.supra))
        coches.add(Coche("Porche", "Taycan", 350, 250000, "Deportivo", R.drawable.taycan))
        var adapterCoche = AdapterCoche(this, coches)
        adapterCoche.funcionComunicar =
            { Snackbar.make(binding.root, it.precio.toString(), Snackbar.LENGTH_SHORT).show() }
        binding.recycler.adapter = adapterCoche;
        binding.recycler.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        //binding.recycler.layoutManager = GridLayoutManager(this, 2);


        binding.spinnerMarca.adapter = ArrayAdapter.createFromResource(
            applicationContext,
            R.array.lista_marcas, android.R.layout.simple_spinner_item
        )
        (binding.spinnerMarca.adapter as ArrayAdapter<CharSequence>).setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        binding.spinnerPrecio.adapter = ArrayAdapter.createFromResource(
            applicationContext,
            R.array.lista_precios, android.R.layout.simple_spinner_item
        )
        (binding.spinnerPrecio.adapter as ArrayAdapter<CharSequence>).setDropDownViewResource(
            android.R.layout.simple_spinner_dropdown_item
        )

        binding.spinnerMarca.onItemSelectedListener = this
        binding.spinnerPrecio.onItemSelectedListener = this

    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        when (p0!!.id) {
            binding.spinnerPrecio.id -> {
                precio = binding.spinnerPrecio.adapter.getItem(p2).toString()
                Log.v("precio", precio)
                // "Hasta 300000"
                when (p2) {
                    0 -> {
                        adapterCoche.cambiarLista(coches)
                    }
                    1 -> {
                        // hasta 100000
                        // de la lista de coche que esta en el spinner saco los que valen hasta 100mil
                        adapterCoche.cambiarLista(adapterCoche.lista.filter { it.precio <= 100000 } as ArrayList<Coche>)
                    }
                    2 -> {
                        adapterCoche.cambiarLista(adapterCoche.lista.filter { it.precio <= 200000 } as ArrayList<Coche>)

                    }
                    3 -> {
                        adapterCoche.cambiarLista(adapterCoche.lista.filter { it.precio <= 300000 } as ArrayList<Coche>)

                    }
                    4 -> {
                        adapterCoche.cambiarLista(adapterCoche.lista.filter { it.precio <= 400000 } as ArrayList<Coche>)

                    }
                    5 -> {
                        adapterCoche.cambiarLista(adapterCoche.lista.filter { it.precio >= 500000 } as ArrayList<Coche>)

                    }
                }
            }
            binding.spinnerMarca.id -> {
                marca = binding.spinnerMarca.adapter.getItem(p2).toString()
                //Log.v("marca", marca)
                // método filter da una lista ya filtrada sobre una condicion
                if (marca.equals("todos", true)) {
                    adapterCoche.cambiarLista(coches)
                } else {
                    adapterCoche.cambiarLista(coches.filter { it.marca == marca } as ArrayList)
                }


            }
        }
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {

    }


}