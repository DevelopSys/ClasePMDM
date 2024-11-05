package com.example.botones

import android.os.Bundle
import android.widget.CompoundButton
import android.widget.CompoundButton.OnCheckedChangeListener
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.botones.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), OnCheckedChangeListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var listaImagenes: ArrayList<Int>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        instancias()
    }
    fun instancias(){
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
        }
    }

    override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
        when(buttonView?.id){
            binding.toggleActivar.id->{
                binding.btnEnviar.isEnabled = isChecked
            }
        }
    }
}