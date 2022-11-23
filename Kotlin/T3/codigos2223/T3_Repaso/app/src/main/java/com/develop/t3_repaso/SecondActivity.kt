package com.develop.t3_repaso

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import android.widget.RadioGroup
import com.develop.t3_repaso.adapters.AdapterLenguaje
import com.develop.t3_repaso.databinding.ActivitySecondBinding
import com.develop.t3_repaso.model.Lenguaje

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding
    private lateinit var listaLenguajes: ArrayList<Lenguaje>;
    private lateinit var adaptadorLenguaje: AdapterLenguaje;
    private lateinit var radioSeleccionado: RadioButton;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        instancias()
        asociarDatos()
        acciones();

    }

    private fun asociarDatos() {

        binding.spinnerLenguaje.adapter = adaptadorLenguaje;
    }

    private fun instancias() {

        listaLenguajes = ArrayList();
        listaLenguajes.add(Lenguaje("Java",R.drawable.java))
        listaLenguajes.add(Lenguaje("Kotlin",R.drawable.kotlin))
        listaLenguajes.add(Lenguaje("Python",R.drawable.python))
        listaLenguajes.add(Lenguaje("JS",R.drawable.js))
        adaptadorLenguaje = AdapterLenguaje(listaLenguajes,applicationContext);
        adaptadorLenguaje.notifyDataSetChanged()

    }

    private fun acciones() {
        // cambio en el grupo
        binding.grupoAsignaturas.setOnCheckedChangeListener { radioGroup, i ->
            radioSeleccionado = findViewById(i);
            binding.editNota1.setHint("Nota de la asignatura "+radioSeleccionado.text)
            binding.editNota2.setHint("Nota de la asignatura "+radioSeleccionado.text)
        }

        binding.botonCalcular.setOnClickListener {
            // recepcionar datos
            var nombre: String = intent.extras!!.getString("nombre")!!;
            var apellido: String = intent.extras!!.getString("apellido")!!;
            var intent = Intent(applicationContext,ThirdActivity::class.java);
            var bundle = Bundle();
            bundle.putString("nombre",nombre)
            bundle.putString("apellido",apellido)
            bundle.putInt("nota1",binding.editNota1.text.toString().toInt())
            bundle.putInt("nota2",binding.editNota2.text.toString().toInt())
            bundle.putString("asignatura",radioSeleccionado.text.toString())
            bundle.putSerializable("lenguaje",adaptadorLenguaje.getItem(binding.spinnerLenguaje.selectedItemPosition))
            intent.putExtras(bundle)
            startActivity(intent)
        }

    }
}