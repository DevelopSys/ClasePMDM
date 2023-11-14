package com.example.t3_ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.Data
import android.view.View
import android.view.View.OnClickListener
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import android.widget.Button
import androidx.core.view.children
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.t3_ui.adapters.AdaptadorModelos
import com.example.t3_ui.adapters.AdaptadorRecycler
import com.example.t3_ui.data.DataSet
import com.example.t3_ui.databinding.ActivitySecondBinding
import com.example.t3_ui.model.Marca
import com.example.t3_ui.model.Modelo
import com.example.t3_ui.model.Usuario
import com.google.android.material.snackbar.Snackbar

class SecondActivity : AppCompatActivity(), OnClickListener, OnItemSelectedListener {


    private lateinit var binding: ActivitySecondBinding
    private var usuario: Usuario? = null;
    private lateinit var listaMarcas: ArrayList<Marca>
    private lateinit var listaModelos: ArrayList<Modelo>
    private lateinit var adaptadorMarcas: ArrayAdapter<Marca>
    private lateinit var adaptadorModelos: AdaptadorModelos
    private lateinit var adaptadorRecycler: AdaptadorRecycler


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // instancias
        usuario = intent.extras?.getSerializable("usuario") as Usuario
        listaMarcas = ArrayList();

        adaptadorMarcas = ArrayAdapter(applicationContext, android.R.layout.simple_spinner_item,
            listaMarcas)
        listaModelos = ArrayList()
        adaptadorModelos = AdaptadorModelos(listaModelos,applicationContext)
        adaptadorRecycler = AdaptadorRecycler(DataSet.getListaModelos(),applicationContext);
    }

    override fun onStart() {
        super.onStart()
        // cambios graficos
        // poner el correo en su sitio
        listaMarcas.add(Marca("Mercedes",4.9,R.drawable.mercedes))
        listaMarcas.add(Marca("Audi",4.9,R.drawable.audi))
        listaMarcas.add(Marca("Ford",4.9,R.drawable.ford))

        binding.spinnerMarcas.adapter = adaptadorMarcas
        adaptadorMarcas.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.nombreUsuario.text = usuario?.correo ?: "Invitado"


        listaModelos.add(Modelo("GT40","Ford",300,100000,"Clasico", R.drawable.fordgt))
        listaModelos.add(Modelo("Mustang","Ford",400,50000,"Deportivo", R.drawable.fordmustang))
        binding.spinnerModelos.adapter = adaptadorModelos

        binding.recyclerModelos.adapter = adaptadorRecycler
        binding.recyclerModelos.layoutManager =
            LinearLayoutManager(applicationContext,
                LinearLayoutManager.VERTICAL
            , false)

    }

    override fun onResume() {
        super.onResume()
        // para acciones
        binding.imagenLogout.setOnClickListener(this)
        binding.botonAdd.setOnClickListener(this)
        binding.spinnerMarcas.onItemSelectedListener = this;
        binding.spinnerModelos.onItemSelectedListener = this;
    }

    override fun onClick(v: View?) {
        when(v?.id){
            binding.imagenLogout.id ->{
               finish()
            }
            binding.botonAdd.id ->{
                // añadir un modelo -> adaptador
                adaptadorModelos.addModelo(Modelo("E-tron", "Mercedes",400,150000,"Electrico", R.drawable.audietron))
            }
        }
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        when(parent?.id){
            binding.spinnerMarcas.id->{
               val marca = binding.spinnerMarcas.selectedItem as Marca
                var lista: ArrayList<Modelo> = ArrayList();
                if (marca.marca.equals("Mercedes")){
                    lista.add(Modelo("C220","Mercedes",200,50000,"Deportivo",R.drawable.mercedes220))
                    lista.add(Modelo("C Coupe","Mercedes",300,60000,"Deportivo",R.drawable.mercedesc))
                } else if (marca.marca.equals("Audi")){
                    lista.add(Modelo("Etron","Audi",300,70000,"Electrico",R.drawable.audietron))
                    lista.add(Modelo("RS6","Audi",400,80000,"Deportivo",R.drawable.audirs6))
                } else if (marca.marca.equals("Ford")){
                    lista.add(Modelo("Etron","Audi",300,70000,"Electrico",R.drawable.audietron))
                    lista.add(Modelo("RS6","Audi",400,80000,"Deportivo",R.drawable.audirs6))
                }
                adaptadorModelos.setLista(lista)
            }
            binding.spinnerModelos.id->{
                val modelo = binding.spinnerModelos.selectedItem as Modelo

            }
        }
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        parent?.adapter?.getItem(binding.spinnerModelos.selectedItemPosition)
    }
}