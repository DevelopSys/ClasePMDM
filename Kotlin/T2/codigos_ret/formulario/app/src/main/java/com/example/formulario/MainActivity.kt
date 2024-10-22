package com.example.formulario

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import com.example.formulario.databinding.ActivityMainBinding
import com.example.formulario.model.Usuario
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

    private fun acciones() {
        // asociar un elemento a un tipo de evento boton - escucha cuando se pulsa
        binding.botonLogin.setOnClickListener(this)
        binding.botonClear.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            binding.botonLogin.id -> {
                // pasar a la segunda pantalla
                val intent: Intent = Intent(applicationContext, SecondActivity::class.java)
                val bundle: Bundle = Bundle()
                /*bundle.putString("nombre", binding.editNombre.text.toString())
                bundle.putString("correo", binding.editCorreo.text.toString())
                bundle.putString("pass", binding.editPass.text.toString())
                bundle.putBoolean("recordar", binding.checkRecordar.isChecked)*/
                bundle.putSerializable(
                    "usuario",
                    Usuario(
                        binding.editNombre.text.toString(),
                        binding.editCorreo.text.toString(),
                        binding.editPass.text.toString(),
                        binding.checkRecordar.isChecked
                    )
                )
                intent.putExtra("datos", bundle)
                startActivity(intent)
            }
            binding.botonClear.id -> {
                resetearDatos()
            }
        }
    }

    override fun onStop() {
        super.onStop()
        Log.v("cambio", "la pantalla con nombre Main esta parada")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.v("cambio", "la pantalla con nombre Main esta destruida")
    }

    override fun onRestart() {
        super.onRestart()
        Log.v("cambio", "la pantalla con nombre Main esta en restart")
        resetearDatos()
    }

    private fun resetearDatos(){
        binding.editNombre.text.clear()
        binding.editCorreo.text.clear()
        binding.editPass.text.clear()
        binding.checkRecordar.isChecked = false
    }


}