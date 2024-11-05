package com.example.botones

import android.os.Bundle
import android.widget.CompoundButton
import android.widget.CompoundButton.OnCheckedChangeListener
import android.widget.RadioButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.botones.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(), OnCheckedChangeListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var listaImagenes: ArrayList<Int>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        instancias()
    }

    fun instancias() {
        listaImagenes = arrayListOf(R.drawable.background2, R.drawable.background1);
    }

    override fun onResume() {
        super.onResume()
        acciones()
    }


    private fun acciones() {
        binding.toggleActivar.setOnCheckedChangeListener(this)
        binding.btnCheck.setOnCheckedChangeListener(this)
        binding.btnSwitch.setOnCheckedChangeListener(this)
        binding.btnEnviar.setOnClickListener {
            binding.imagenHeader.setImageResource(listaImagenes.random())

            when (binding.grupOpcione.checkedRadioButtonId) {
                binding.radioUno.id -> {}
                binding.radioDos.id -> {}
                binding.radioTres.id -> {}
            }

            val seleccionado: RadioButton? =
                findViewById(binding.grupOpcione.checkedRadioButtonId)

            Snackbar.make(
                binding.root,
                seleccionado?.text ?: "No hay seleccion", Snackbar.LENGTH_SHORT
            ).show()
        }
        binding.grupOpcione.setOnCheckedChangeListener { _, checkedId ->

            when(checkedId){
                binding.radioUno.id->{
                    binding.imagenHeader.setImageResource(R.drawable.background1)
                }
                binding.radioDos.id->{
                    binding.imagenHeader.setImageResource(R.drawable.background2)
                }
                binding.radioTres.id->{
                    binding.imagenHeader.setImageResource(R.drawable.ic_launcher_background)
                }
            }
        }
    }

    override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
        when (buttonView?.id) {
            binding.toggleActivar.id -> {
                binding.btnEnviar.isEnabled = isChecked
            }
        }
    }
}