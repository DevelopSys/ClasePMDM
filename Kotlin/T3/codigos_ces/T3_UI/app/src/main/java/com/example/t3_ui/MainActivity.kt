package com.example.t3_ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.Button
import android.widget.CompoundButton
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.RadioGroup.OnCheckedChangeListener
import android.widget.Toast
import com.example.t3_ui.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(), OnClickListener{


    private lateinit var binding: ActivityMainBinding
    private lateinit var perfil: String;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.botonLimpiar.setOnLongClickListener {

            binding.editNombre.text.clear()
            binding.editPass.text.clear()
            binding.editCorreo.text.clear()
            binding.grupoTipo.clearCheck()
            binding.spinnerPerfil.setSelection(0)
            binding.checkRecordad.isChecked = false;
            return@setOnLongClickListener true
        }
        binding.botonLimpiar.setOnClickListener(this)
        binding.botonRegistrar.setOnClickListener(this)
        binding.checkRecordad.setOnCheckedChangeListener { _, isChecked ->  }
        binding.grupoTipo.setOnCheckedChangeListener { _, checkedId ->

            if (checkedId>-1){
                val seleccion = (findViewById<RadioButton>(checkedId)).text.toString()
                binding.checkRecordad.isEnabled = !seleccion.equals("mensual")
            }

            //Snackbar.make(binding.root, seleccion, Snackbar.LENGTH_SHORT).show()
        }
        binding.spinnerPerfil.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                //binding.spinnerPerfil.selectedItem
                perfil = parent?.adapter?.getItem(position).toString()
                val perfiles = resources.getStringArray(R.array.perfiles)
                if (perfil.equals("invitado",true)){
                    binding.grupoTipo.isEnabled = false
                    binding.checkRecordad.isEnabled =false;
                } else {
                    binding.grupoTipo.isEnabled = true
                    binding.checkRecordad.isEnabled =true;
                }
                //Snackbar.make(binding.root, seleccionado, Snackbar.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

        }
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            binding.botonLimpiar.id -> {
                Snackbar.make(binding.root, "Pulsado normal", Snackbar.LENGTH_SHORT).show()
            }
            binding.botonRegistrar.id -> {
                if (!binding.editNombre.text.isEmpty()
                    && !binding.editCorreo.text.isEmpty()
                    && !binding.editPass.text.isEmpty()
                    && (!perfil.equals("invitado") && binding.grupoTipo.checkedRadioButtonId>-1)
                ){

                } else {
                    Snackbar.make(binding.root, "Faltan datos por rellenar", Snackbar.LENGTH_SHORT).show()
                }
                /*val seleccionado = binding.spinnerPerfil.selectedItem.toString()
                val seleccion = findViewById<RadioButton>(binding.grupoTipo
                    .checkedRadioButtonId).text
                Snackbar.make(binding.root, seleccionado, Snackbar.LENGTH_SHORT).show()*/
                //Toast.makeText(applicationContext, seleccion, Toast.LENGTH_SHORT).show()
            }
        }
    }

}