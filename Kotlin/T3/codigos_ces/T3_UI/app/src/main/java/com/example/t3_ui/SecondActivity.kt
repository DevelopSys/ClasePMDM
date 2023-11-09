package com.example.t3_ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import com.example.t3_ui.databinding.ActivitySecondBinding
import com.example.t3_ui.model.Marca
import com.example.t3_ui.model.Usuario

class SecondActivity : AppCompatActivity(), OnClickListener, OnItemSelectedListener {


    private lateinit var binding: ActivitySecondBinding
    private var usuario: Usuario? = null;
    private lateinit var listaMarcas: ArrayList<Marca>
    private lateinit var adaptadorMarcas: ArrayAdapter<Marca>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // instancias
        usuario = intent.extras?.getSerializable("usuario") as Usuario
        listaMarcas = ArrayList();

        adaptadorMarcas = ArrayAdapter(applicationContext, android.R.layout.simple_spinner_item,
            listaMarcas)

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
    }

    override fun onResume() {
        super.onResume()
        // para acciones
        binding.imagenLogout.
        setOnClickListener(this)
        binding.spinnerMarcas.onItemSelectedListener = this;
        binding.spinnerModelos.onItemSelectedListener = this;
    }

    override fun onClick(v: View?) {
        when(v?.id){
            binding.imagenLogout.id ->{
               finish()
            }
        }
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        when(parent?.id){
            binding.spinnerMarcas.id->{
               val marca = binding.spinnerMarcas.selectedItem as Marca
                binding.logoMarca.setImageResource(marca.imagen)
                binding.textoInfo.text = marca.valoracion.toString()
            }
        }
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {

    }
}