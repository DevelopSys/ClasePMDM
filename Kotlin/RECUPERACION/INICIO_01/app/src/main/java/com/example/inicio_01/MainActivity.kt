package com.example.inicio_01

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import com.example.inicio_01.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationBarView
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var arrayDirecciones: ArrayList<String>
    private lateinit var arrayAdapter: ArrayAdapter<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        arrayDirecciones = ArrayList()
        arrayDirecciones.add("Seleccione vivienda")
        arrayDirecciones.add("Calle")
        arrayDirecciones.add("Paseo")
        arrayDirecciones.add("Ronda")
        arrayDirecciones.add("Finca")

        arrayAdapter = ArrayAdapter(
            applicationContext, android.R.layout.simple_spinner_item, arrayDirecciones
        )

        binding.spinnerDireccion.adapter = arrayAdapter;
        binding.spinnerDireccion.onItemSelectedListener = object : OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                TODO("Not yet implemented")
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        binding.spinnerDireccion.onItemSelectedListener = object : OnItemSelectedListener {

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                if (position != 0)
                    Snackbar.make(
                        binding.root,
                        parent!!.adapter.getItem(position).toString(),
                        Snackbar.LENGTH_LONG
                    ).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }





        binding.botonEnviar.setOnClickListener {
            /*val nombre = binding.inputNombre.text.toString()
            val apellido = binding.inputApellido.text.toString()
            val edad = binding.inputEdad.text.toString().toInt()

            binding.textoNombre.text = nombre
            binding.textoApellido.text = apellido
            binding.textoEdad.text = edad.toString()*/


            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("nombre", binding.inputNombre.text.toString())
            intent.putExtra("apellido", binding.inputApellido.text.toString())
            intent.putExtra("edad", binding.inputEdad.text.toString().toInt())
            startActivity(intent)
        }


    }
}