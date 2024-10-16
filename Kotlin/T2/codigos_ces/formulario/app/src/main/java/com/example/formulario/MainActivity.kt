package com.example.formulario

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import com.example.formulario.databinding.ActivityMainBinding
import com.example.formulario.ui.activity.SecondActivity

class MainActivity : AppCompatActivity(), OnClickListener {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onStart() {
        super.onStart()
        acciones()
    }

    private fun acciones(){
        binding.botonLogin.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v!!.id){
            binding.botonLogin.id->{
                // INTENT origen destino
                val intent: Intent = Intent(applicationContext, SecondActivity::class.java);
                val bundle: Bundle = Bundle();
                bundle.putString("nombre", binding.editNombre.text.toString())
                bundle.putString("correo", binding.editCorreo.text.toString())
                bundle.putString("pass", binding.editPass.text.toString())
                bundle.putBoolean("recordar", binding.checkRecordar.isChecked)
                intent.putExtra("datos",bundle)
                startActivity(intent)
                // finish()
            }
        }
    }
}