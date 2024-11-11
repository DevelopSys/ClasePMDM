package com.example.botones

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.view.View.OnLongClickListener
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import android.widget.CompoundButton
import android.widget.CompoundButton.OnCheckedChangeListener
import android.widget.RadioButton
import android.widget.RadioGroup
import com.example.botones.databinding.ActivityMainBinding
import com.example.botones.model.Ciclo
import com.google.android.material.snackbar.Snackbar

// HACER UN SPINNER NUEVO CON DATOS DE CICLOS
// LOS CICLOS SON OBJETOS CON LAS CARACTERISTICAS DE NOMBRE, SIGLAS Y FAMILIA
// DENTRO DEL SPINNER SOLO SE VERA LAS SIGLAS

class MainActivity : AppCompatActivity(),
    OnCheckedChangeListener, OnClickListener, OnLongClickListener,
    RadioGroup.OnCheckedChangeListener, OnItemSelectedListener {

    private lateinit var binding: ActivityMainBinding

    // objetos relacionados con el array dinamico
    private var imagenesTitle = arrayListOf(R.drawable.background1, R.drawable.background2)

    // desde bbdd
    private lateinit var listaDinamica: ArrayList<CharSequence>;
    private lateinit var adapterCursosDinamico: ArrayAdapter<CharSequence>

    // objectos relacionados con el spinner ciclos

    private lateinit var listaCiclos: ArrayList<Ciclo>
    private lateinit var adapterCiclos: ArrayAdapter<Ciclo>

    // oncreate -> onstart -> onresume
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.imgTitle.setImageResource(imagenesTitle[(0..1).random()])
        instancias()


    }

    private fun instancias() {
        // conectar con la bd y traer todos los elementos
        listaDinamica = arrayListOf("DAM", "DAW", "ASIR")
        listaCiclos = arrayListOf(
            Ciclo("Administracion de sistemas", "ASIR", "Informativa"),
            Ciclo("Desarrollo Multiplataforma", "DAM", "Informativa"),
            Ciclo("Desarrollo Web", "DAW", "Informativa"),
            Ciclo("Admnistracion y Finanzas", "AF", "Administracion")
        )
        // contexto -> applicationContext - this
        // vista -> android.R.layout.simple_spinner_item
        // lista -> datos que se quieren mostrar
        // adapterCursosDinamico
        adapterCursosDinamico =
            ArrayAdapter(applicationContext, android.R.layout.simple_spinner_item, listaDinamica)
        adapterCursosDinamico.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        adapterCiclos =
            ArrayAdapter(applicationContext, android.R.layout.simple_spinner_item, listaCiclos)
        adapterCiclos.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

    }

    override fun onResume() {
        super.onResume()
        acciones()

    }

    override fun onStart() {
        super.onStart()
        // juntar la parte grafica del spinner con sus datos
        binding.spinnerDinamico.adapter = adapterCursosDinamico;
        binding.spinnerCiclosDinamico.adapter = adapterCiclos

    }

    fun acciones() {
        // binding.swOnOff.setOnCheckedChangeListener { _, isChecked ->  }
        binding.swOnOff.setOnCheckedChangeListener(this)
        binding.checkbox.setOnCheckedChangeListener(this)
        binding.grRadios.setOnCheckedChangeListener(this)
        binding.imgButton.setOnClickListener(this)
        binding.imgButton.setOnLongClickListener(this)
        binding.spinnerSencillo.setOnItemSelectedListener(this)
        binding.spinnerDinamico.setOnItemSelectedListener(this)
        binding.spinnerCiclosDinamico.setOnItemSelectedListener(this)
    }


    override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
        when (buttonView?.id) {
            binding.swOnOff.id -> {
                if (isChecked) {
                    binding.txSwitch.text = "Te han activado"
                    binding.imgButton.isEnabled = true
                    binding.layoutGeneral.isEnabled = true
                } else {

                    binding.imgButton.isEnabled = false
                    binding.layoutGeneral.isEnabled = false
                    binding.txSwitch.text = "Te han desactivado"
                }
            }

            binding.checkbox.id -> {
                binding.txCheck.text = isChecked.toString()
            }
        }

    }

    override fun onClick(v: View?) {
        when (v?.id) {
            binding.imgButton.id -> {
                listaDinamica.add("AF")
                // cada vez que hay un cambio
                adapterCursosDinamico.notifyDataSetChanged()
                binding.imgTitle.setImageResource(imagenesTitle[(0..1).random()])
                // binding.grRadios.checkedRadioButtonId -> el id del que esta seleccionado
                val radioSeleccionado: RadioButton? =
                    findViewById(binding.grRadios.checkedRadioButtonId)
                binding.txRadio.text = radioSeleccionado?.text ?: "No han seleccion"
            }
        }
    }

    override fun onLongClick(v: View?): Boolean {

        when (v?.id) {
            binding.imgButton.id -> {
                binding.swOnOff.isChecked = !binding.swOnOff.isChecked
            }
        }

        return true
    }

    override fun onCheckedChanged(group: RadioGroup?, checkedId: Int) {
        val radioSeleccionado: RadioButton = findViewById(checkedId)
        binding.txRadio.text = radioSeleccionado.text
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        // cuando has desplegado y seleccionado algo
        // parent -> quien ha generado el evento
        // position -> la posicion pulsada
        // id -> el id de la fila pulsada
        when (parent!!.id) {
            binding.spinnerSencillo.id -> {
                if (position > 0) {
                    // val curso = resources.getStringArray(R.array.spinner_base)[position]
                    val curso = parent.adapter.getItem(position)
                    Snackbar.make(
                        binding.root,
                        "El curso seleccionado es ${curso}",
                        Snackbar.LENGTH_SHORT
                    ).show()
                }
            }

            binding.spinnerDinamico.id -> {
                val curso: CharSequence = adapterCursosDinamico.getItem(position)!!
                Snackbar.make(binding.root,"El seleccionado es ${curso}", Snackbar.LENGTH_SHORT).show()
            }

            binding.spinnerCiclosDinamico.id ->{
                val curso: Ciclo = adapterCiclos.getItem(position)!!
                Snackbar.make(binding.root,"El seleccionado es ${curso.familia}",Snackbar.LENGTH_SHORT).show()
            }
        }

    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        // cuando has desplegado y plegado
    }

}