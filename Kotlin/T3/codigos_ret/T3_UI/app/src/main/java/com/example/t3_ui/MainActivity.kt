package com.example.t3_ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.RadioGroup.OnCheckedChangeListener
import com.example.t3_ui.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(), OnClickListener{

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        acciones()
    }

    private fun acciones() {
        binding.botonLimpiar.setOnClickListener(this)
        binding.botonRegistro.setOnClickListener(this)

        binding.grupoUsuario.setOnCheckedChangeListener { _, checkedId ->
            when(checkedId){
                binding.radioMes.id->{
                    binding.checkDatos.isEnabled = false;
                }
                binding.radioAnual.id->{
                    binding.checkDatos.isEnabled = true;
                }
            }
        }
        binding.checkDatos.setOnCheckedChangeListener { buttonView, isChecked ->
            binding.botonLimpiar.isEnabled = isChecked
        }

        binding.spinnerTipo.onItemSelectedListener  = object : OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val seleccion = parent!!.adapter.getItem(position)
                Snackbar.make(binding.root,"La seleccion es $seleccion",Snackbar.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

        }
    }

    override fun onClick(v: View?) {
        when(v!!.id){
            binding.botonLimpiar.id->{}
            binding.botonRegistrar.id->{
                /*var texto = findViewById<RadioButton>(binding.grupoUsuario.checkedRadioButtonId)
                    .text.toString()
                //var radio: RadioButton = findViewById(binding.grupoUsuario.checkedRadioButtonId);
                Log.v("seleccion",texto)*/
                /*
                // id
                when(binding.grupoUsuario.checkedRadioButtonId){
                    binding.radioAnual.id->{
                        // accion cuando esta el radio Anual
                    }
                    binding.radioMes.id->{
                        // accion cuando esta el radio Mes
                    }
                }*/
                val seleccion = binding.spinnerTipo.selectedItem.toString()
                Snackbar.make(binding.root, "La seleccion es $seleccion", Snackbar.LENGTH_SHORT).show()
            }
        }
    }



}