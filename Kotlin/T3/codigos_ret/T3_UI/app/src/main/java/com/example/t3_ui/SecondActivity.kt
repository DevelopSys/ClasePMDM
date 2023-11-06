package com.example.t3_ui

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.ArrayAdapter
import androidx.annotation.RequiresApi
import com.example.t3_ui.databinding.ActivitySecondBinding
import com.example.t3_ui.model.Marca
import com.example.t3_ui.model.Usuario

class SecondActivity : AppCompatActivity(), OnClickListener {


    private var usuario: Usuario? = null;
    // inicializo los textViews????
    private lateinit var binding: ActivitySecondBinding
    private lateinit var adaptadorMarcas: ArrayAdapter<Marca>
    private lateinit var listaMarcas: ArrayList<Marca>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        usuario = intent.extras?.getSerializable("objeto" ) as Usuario?
        listaMarcas = ArrayList();
        listaMarcas.add(Marca("Mercedes",4.5,R.drawable.logout))
        listaMarcas.add("Audi")
        listaMarcas.add("Ford")
        adaptadorMarcas = ArrayAdapter(applicationContext,android.R.layout.simple_spinner_item,
            listaMarcas)


    }

    override fun onStart() {
        super.onStart()
        binding.textoNombreUsuario.text = usuario?.nombre
        binding.spinnerMarcas.adapter = adaptadorMarcas
        adaptadorMarcas.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
    }
    override fun onResume() {
        super.onResume()
        // acciones
        binding.botonSalir.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            binding.botonSalir.id->{
                finish()
            }
        }
    }


}