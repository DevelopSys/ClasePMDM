package com.develop.interfaz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import com.develop.interfaz.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(), View.OnClickListener {

    /*lateinit var botonAceptar: Button
    lateinit var editTrabajo: EditText
    lateinit var grupoOpciones: RadioGroup*/
    lateinit var binding: ActivityMainBinding;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater);
        setContentView(binding.root)
        // asociadas!!!
        /*botonAceptar = findViewById(R.id.boton_aceptar)
        editTrabajo = findViewById(R.id.edit_profesion)
        grupoOpciones = findViewById(R.id.grupo_radios)*/
        // al pulsar en el boton sacar el texto que hay en el edit
        binding.botonAceptar.setOnClickListener(this)
        binding.grupoRadios.setOnCheckedChangeListener { radioGroup, i ->
            var radioSeleccionado: RadioButton = findViewById(i)
            binding.textoNombre.text = radioSeleccionado.text
        }
        /*binding.botonAceptar.setOnClickListener {

           if (!binding.editProfesion.text.isEmpty()){
               Snackbar.make(
                   binding.botonAceptar,
                   binding.editProfesion.text.toString(),
                   Snackbar.LENGTH_SHORT
               ).show()
           }

        }*/


    }

    override fun onClick(p0: View?) {
        when(p0!!.id){
            R.id.boton_aceptar->{
                if (!binding.editProfesion.text.isEmpty()){

                    var radioSeleccionado : RadioButton = findViewById(binding.grupoRadios.checkedRadioButtonId);

                    Snackbar.make(
                        p0!!,
                        radioSeleccionado.text,
                        Snackbar.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }
}