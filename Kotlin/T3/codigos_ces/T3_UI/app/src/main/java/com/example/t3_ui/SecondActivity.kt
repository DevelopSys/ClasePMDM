package com.example.t3_ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.ArrayAdapter
import com.example.t3_ui.databinding.ActivitySecondBinding
import com.example.t3_ui.model.Usuario

class SecondActivity : AppCompatActivity(), OnClickListener {


    private lateinit var binding: ActivitySecondBinding
    private var usuario: Usuario? = null;
    private lateinit var listaMarcas: ArrayList<CharSequence>
    private lateinit var adaptadorMarcas: ArrayAdapter<CharSequence>

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
        listaMarcas.add("Mercedes")
        listaMarcas.add("Audi")
        listaMarcas.add("Ford")
        binding.spinnerMarcas.adapter = adaptadorMarcas
        adaptadorMarcas.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.nombreUsuario.text = usuario?.correo ?: "Invitado"
    }

    override fun onResume() {
        super.onResume()
        // para acciones
        binding.imagenLogout.
        setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            binding.imagenLogout.id ->{
               finish()
            }
        }
    }
}