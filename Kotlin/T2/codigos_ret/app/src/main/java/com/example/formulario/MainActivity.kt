package com.example.formulario

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.formulario.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        acciones()
    }

    private fun acciones() {
        binding.botonEnviar.setOnClickListener {
            val nombre = binding.editNombre.text.toString()
            val mail = binding.editMail.text.toString()
            val pass = binding.editPass.text.toString()
            val experiencia = binding.checkExperiencia.isChecked
            lateinit var cantidad: String
            if (experiencia) {
                when (binding.grupoRadios.checkedRadioButtonId) {
                    binding.radioCinco.id -> {
                        cantidad = "menos de 5"
                    }

                    binding.radioMasCinco.id -> {
                        cantidad = "mas de 5"
                    }
                }
            } else {
                cantidad = "sin experiencia"
            }
            val estudios = binding.spinnerPuesto.selectedItem
            val intent: Intent = Intent(applicationContext,
                SecondActivity::class.java)
            startActivity(intent)

        }
        binding.checkExperiencia.setOnCheckedChangeListener { view, state ->
            binding.radioCinco.isEnabled = state
            binding.radioMasCinco.isEnabled = state
            binding.grupoRadios.check(-1)
        }
        binding.grupoRadios.setOnCheckedChangeListener { view, element ->
            when (element) {
                binding.radioCinco.id -> {
                    Log.v("radios", "Seleccionado el de menos de 5")
                }

                binding.radioMasCinco.id -> {
                    Log.v("radios", "Seleccionado el de mas de 5")
                }
            }
        }
        binding.spinnerPuesto.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                Log.v("spinner", binding.spinnerPuesto.selectedItem.toString())
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

        }

    }

    override fun onClick(v: View?) {
    }
}