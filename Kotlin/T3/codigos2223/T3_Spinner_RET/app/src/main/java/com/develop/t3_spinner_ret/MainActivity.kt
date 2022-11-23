package com.develop.t3_spinner_ret

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.develop.t3_spinner_ret.adapter.AdapterPais
import com.develop.t3_spinner_ret.databinding.ActivityMainBinding
import com.develop.t3_spinner_ret.model.Pais
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adaptadorSimple: ArrayAdapter<Pais>
    private lateinit var arrayDatos: ArrayList<Pais>
    private lateinit var adaptadorPais: AdapterPais

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // parte grafica binding.spinnerSimple
        // parte logica --> lista de datos (Array - ArrayList ó un recurso),
        //                  vista gráfica --> android.R.layout.simple_spinner_item_1
        //                  contexto --> getApplicationContext
        instancias()
        asociarDatos()
        rellenarLista();
        acciones()

        var intent : Intent = Intent()
        var bundle: Bundle = Bundle()
        bundle.putSerializable("equipo",adaptadorPais.getItem(binding.spinnerComplejo.selectedItemPosition))
    }

    private fun acciones() {
        binding.spinnerComplejo.onItemSelectedListener = this
        binding.spinnerSimple.onItemSelectedListener = this
        binding.botonAgregar.setOnClickListener {
            //arrayDatos.add("Dato nuevo")
            adaptadorSimple.notifyDataSetChanged()
        }
    }


    private fun rellenarLista() {
        /*arrayDatos.add("Elemento uno")
        arrayDatos.add("Elemento dos")
        arrayDatos.add("Elemento tres")
        arrayDatos.add("Elemento cuatro")*/
        arrayDatos.add(Pais("España",R.drawable.espania,1,"Pedri"))
        arrayDatos.add(Pais("Brasil",R.drawable.brasil,5,"Neymar"))
        arrayDatos.add(Pais("Alemania",R.drawable.alemania,3,"Muller"))
        arrayDatos.add(Pais("Argentina",R.drawable.argentina,2,"MESSI"))
        arrayDatos.add(Pais("Francia",R.drawable.francia,2,"Mbappe"))
        arrayDatos.add(Pais("Qatar",R.drawable.qatar,0,"Desconocido"))
        adaptadorSimple.notifyDataSetChanged()
        adaptadorPais.notifyDataSetChanged()
    }

    private fun asociarDatos() {
        binding.spinnerSimple.adapter = adaptadorSimple
        binding.spinnerComplejo.adapter = adaptadorPais;
    }

    private fun instancias() {
        arrayDatos = ArrayList();
        adaptadorPais = AdapterPais(arrayDatos,applicationContext);
        adaptadorSimple = ArrayAdapter(applicationContext,
            android.R.layout.simple_spinner_item, arrayDatos)
        adaptadorSimple.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        /*adaptadorSimple = ArrayAdapter.createFromResource(
            applicationContext, R.array.array_recurso, android.R.layout.simple_spinner_item
        )*/
    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        // p0 --> vista del evento
        // p1 --> la fila que se ha pulsado
        // p2 --> la posicion pulsada 0...n
        // p3 --> id (pk): id --> posicion

        when(p0!!.id){
            R.id.spinner_simple -> {
                Snackbar.make(binding.spinnerSimple,
                    adaptadorSimple.getItem(p2)?.getEstrella() ?: "No hay datos",
                    Snackbar.LENGTH_SHORT)
                    .show()
            }
            R.id.spinner_complejo -> {
                binding.imagenEscudo.setImageResource(adaptadorPais.getItem(p2).getImagen())
            }
        }


    }

    override fun onNothingSelected(p0: AdapterView<*>?) {

    }
}