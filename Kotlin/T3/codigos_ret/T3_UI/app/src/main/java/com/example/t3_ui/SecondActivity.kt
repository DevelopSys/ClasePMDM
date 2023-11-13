package com.example.t3_ui

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.t3_ui.adapters.AdaptadorRecycler
import com.example.t3_ui.adapters.AdaptadorSpinnerModelo
import com.example.t3_ui.data.DataSet
import com.example.t3_ui.databinding.ActivitySecondBinding
import com.example.t3_ui.model.Marca
import com.example.t3_ui.model.Modelo
import com.example.t3_ui.model.Usuario

class SecondActivity : AppCompatActivity(), OnClickListener, OnItemSelectedListener {


        // cuando se cambie el spinner -> OnItemSelected
        // filter
        // adaptador

    private var usuario: Usuario? = null;
    // inicializo los textViews????
    private lateinit var binding: ActivitySecondBinding
    private lateinit var adaptadorMarcas: ArrayAdapter<Marca>
    private lateinit var listaMarcas: ArrayList<Marca>
    private lateinit var adaptadorRecycler: AdaptadorRecycler
    private lateinit var listaModelosRecycler: ArrayList<Modelo>
    private lateinit var adaptadorModelos: AdaptadorSpinnerModelo
    private lateinit var listaModelos: ArrayList<Modelo>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        usuario = intent.extras?.getSerializable("objeto" ) as Usuario?
        listaMarcas = ArrayList();
        listaMarcas.add(Marca("Mercedes",4.5,R.drawable.mercedes))
        listaMarcas.add(Marca("Audi",4.3,R.drawable.audi))
        listaMarcas.add(Marca("Ford",4.1,R.drawable.ford))
        adaptadorMarcas = ArrayAdapter(applicationContext,android.R.layout.simple_spinner_item,
            listaMarcas)
        listaModelos = ArrayList()
        listaModelos.add(Modelo("GT40", "Ford",100000,300,R.drawable.fordgt))
        listaModelos.add(Modelo("Mustang", "Ford",60000,250,R.drawable.fordmustang))
        adaptadorModelos = AdaptadorSpinnerModelo(listaModelos,applicationContext)

        listaModelosRecycler = DataSet.obtenerListaCompleta();
        adaptadorRecycler = AdaptadorRecycler(listaModelosRecycler)
    }

    override fun onStart() {
        super.onStart()
        binding.textoNombreUsuario.text = usuario?.nombre
        binding.spinnerMarcas.adapter = adaptadorMarcas
        adaptadorMarcas.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerModelos.adapter = adaptadorModelos
        binding.recyclerModelos.adapter = adaptadorRecycler
        binding.recyclerModelos.layoutManager = LinearLayoutManager(applicationContext,LinearLayoutManager.VERTICAL,false)
    }
    override fun onResume() {
        super.onResume()
        // acciones
        binding.botonSalir.setOnClickListener(this)
        binding.botonAdd.setOnClickListener(this)
        // al cambiar de seleccion cambie imagen y valoracion
        binding.spinnerMarcas.onItemSelectedListener = this
        binding.spinnerModelos.onItemSelectedListener = this
    }

    override fun onClick(v: View?) {
        when(v?.id){
            binding.botonAdd.id->{
                // añadir un modelo nuevo al adaptador
                adaptadorModelos.addModelo(Modelo("Ejemplo","Ejemplo",12,123,R.drawable.audirs6))
            }
            binding.botonSalir.id->{
                finish()
            }
        }
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
       // quien ha generado el evento when(parent.id)
        when(parent?.id){
            binding.spinnerMarcas.id->{
                // sacar la marca seleccinada y de ahi sacar imagen y la val
                //binding.spinnerMarcas.selectedItem

                // TODO 1. saber que marca tengo seleccionada
                val marcaSeleccionada = parent.adapter.getItem(position) as Marca

                // TODO 2. sacar los modelos de la marca del paso 1
                val listaFiltrada: ArrayList<Modelo> = DataSet.obtenerListaCompleta()
                    .filter { it.marca.equals(marcaSeleccionada.nombre,true) } as ArrayList<Modelo>


                // TODO 3. cambiar los modelos del spinner a los obtenidos en el paso 2
                adaptadorModelos.cambiarListaModelos(listaFiltrada)

                // cambiar la lista del apadaptar de los modelos
                //binding.imagenMarca.setImageResource(marca.imagen)
                //binding.textoValoracion.text = marca.calificacion.toString()
            }
            binding.spinnerModelos.id->{
                val modelo = parent.adapter.getItem(position) as Modelo
            }
        }
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {

    }


}