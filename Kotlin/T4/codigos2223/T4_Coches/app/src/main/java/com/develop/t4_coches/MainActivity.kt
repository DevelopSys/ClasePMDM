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
// TODO 5. Utilizo el dato comunicado como me interese en el metodo implementado --> coche comunicado

class MainActivity : AppCompatActivity(), OnItemSelectedListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var coches: ArrayList<Coche>
    private lateinit var cochesFiltrada: ArrayList<Coche>
    private lateinit var adapterCoche: AdapterCoche

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


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
        coches.add(Coche("Ferrari", "Le ferrari", 600, 500000, "Deportivo", R.drawable.leferrari))
        coches.add(Coche("McLaren", "MC600", 500, 450000, "Deportivo", R.drawable.mc600))
        coches.add(Coche("Toyota", "Supra", 300, 150000, "Deportivo", R.drawable.supra))
        coches.add(Coche("Porche", "Taycan", 350, 250000, "Deportivo", R.drawable.taycan))
        cochesFiltrada = coches;
        adapterCoche = AdapterCoche(this, cochesFiltrada)
        binding.recycler.adapter = adapterCoche;
        //binding.recycler.layoutManager =
        //    LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.recycler.layoutManager = GridLayoutManager(this, 2);




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

        binding.spinnerPrecio.onItemSelectedListener = this;
        binding.spinnerMarca.onItemSelectedListener = this;
        /*binding.spinnerMarca.onItemSelectedListener = object : OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }*/


    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        when(p0!!.id){
            R.id.spinner_marca->{

                val marca = binding.spinnerMarca.adapter.getItem(p2)

                if (marca == "Todos"){
                    Log.v("marca", marca.toString() + "todos")
                    cochesFiltrada = coches
                } else {
                    Log.v("marca", marca.toString() + "diferente")
                    cochesFiltrada =
                        coches.filter { it.marca == marca  } as ArrayList<Coche> // lista de los que cumplen
                }
                adapterCoche.setFiltrada(cochesFiltrada);

            }
            R.id.spinner_precio->{
                val precio = binding.spinnerPrecio.adapter.getItem(p2)
                cochesFiltrada = cochesFiltrada.filter {
                    when(p2){

                        1->{
                            return@filter it.precio>100000
                        }
                        2->{
                            return@filter it.precio>200000
                        }
                        3->{
                            return@filter it.precio>300000
                        }
                        4->{
                            return@filter it.precio>400000
                        }
                        5->{
                            return@filter it.precio>500000
                        }
                    }
                    return@filter true;

                } as ArrayList<Coche>
                adapterCoche.setFiltrada(cochesFiltrada)

            }
        }
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {

    }
}