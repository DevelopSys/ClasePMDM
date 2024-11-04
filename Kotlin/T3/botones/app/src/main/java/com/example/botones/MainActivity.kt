package com.example.botones

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.view.View.OnLongClickListener
import android.widget.ArrayAdapter
import android.widget.CompoundButton
import android.widget.CompoundButton.OnCheckedChangeListener
import android.widget.RadioButton
import android.widget.RadioGroup
import com.example.botones.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(),
    OnCheckedChangeListener, OnClickListener, OnLongClickListener, RadioGroup.OnCheckedChangeListener{

    private lateinit var binding: ActivityMainBinding

    // objetos relacionados con el array dinamico
    private var imagenesTitle = arrayListOf(R.drawable.background1, R.drawable.background2)
    private var listaDinamica:ArrayList<CharSequence> = arrayListOf("DAM","DAW","ASIR")
    private lateinit var adapterCursosDinamico: ArrayAdapter<CharSequence>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.imgTitle.setImageResource(imagenesTitle[(0..1).random()])
        // binding.swOnOff.setOnCheckedChangeListener { _, isChecked ->  }
        binding.swOnOff.setOnCheckedChangeListener(this)
        binding.checkbox.setOnCheckedChangeListener(this)
        binding.grRadios.setOnCheckedChangeListener(this)
        binding.imgButton.setOnClickListener(this)
        binding.imgButton.setOnLongClickListener(this)
    }

    override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
        when(buttonView?.id){
            binding.swOnOff.id->{
                if (isChecked){
                    binding.txSwitch.text = "Te han activado"
                    binding.imgButton.isEnabled = true
                    binding.layoutGeneral.isEnabled = true
                } else {

                    binding.imgButton.isEnabled = false
                    binding.layoutGeneral.isEnabled = false
                    binding.txSwitch.text = "Te han desactivado"
                }
            }
            binding.checkbox.id ->{
                binding.txCheck.text = isChecked.toString()
            }
        }

    }
    override fun onClick(v: View?) {
        when(v?.id){
            binding.imgButton.id->{
                binding.imgTitle.setImageResource(imagenesTitle[(0..1).random()])
                // binding.grRadios.checkedRadioButtonId -> el id del que esta seleccionado
                val radioSeleccionado: RadioButton? = findViewById(binding.grRadios.checkedRadioButtonId)
                binding.txRadio.text = radioSeleccionado?.text ?: "No han seleccion"
            }
        }
    }
    override fun onLongClick(v: View?): Boolean {

        when(v?.id){
            binding.imgButton.id->{
               binding.swOnOff.isChecked = !binding.swOnOff.isChecked
            }
        }

        return true
    }

    override fun onCheckedChanged(group: RadioGroup?, checkedId: Int) {
        val radioSeleccionado: RadioButton = findViewById(checkedId)
        binding.txRadio.text = radioSeleccionado.text
    }

}