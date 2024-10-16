package com.example.formulario

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.view.View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
import com.example.formulario.databinding.ActivityMainBinding
import com.example.formulario.model.Usuario
import com.example.formulario.ui.activity.SecondActivity
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(), OnClickListener {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }


    override fun onRestart() {
        super.onRestart()
        limpiarDatos()
    }

    override fun onStart() {
        super.onStart()
        acciones()
    }

    private fun acciones() {
        binding.botonLogin.setOnClickListener(this)
        binding.botonVaciar.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            binding.botonLogin.id -> {

                if (
                    binding.editNombre.text.isNotEmpty()
                    && binding.editCorreo.text.isNotEmpty()
                    && binding.editPass.text.isNotEmpty()
                    && binding.editCorreo.text.toString().contains("@")
                ) {
                    // INTENT origen destino
                    val intent: Intent = Intent(applicationContext, SecondActivity::class.java);
                    val bundle: Bundle = Bundle();
                    //bundle.putString("nombre", binding.editNombre.text.toString())
                    //bundle.putString("correo", binding.editCorreo.text.toString())
                    //bundle.putString("pass", binding.editPass.text.toString())
                    //bundle.putBoolean("recordar", binding.checkRecordar.isChecked)
                    val usuario = Usuario(
                        binding.editNombre.text.toString(),
                        binding.editCorreo.text.toString(),
                        binding.editPass.text.toString(),
                        binding.checkRecordar.isChecked
                    )
                    bundle.putSerializable("usuario", usuario)
                    intent.putExtra("datos", bundle)
                    startActivity(intent)
                    // finish()
                } else {
                    val notificacion: Snackbar = Snackbar.make(
                        binding.root,
                        "Fallo a la hora de pasar de pantalla",
                        Snackbar.LENGTH_SHORT
                    )
                    notificacion.setAction("Entrar como invidado"){
                        val intent: Intent = Intent(applicationContext, SecondActivity::class.java);
                        val bundle = Bundle();
                        bundle.putSerializable("usuario", Usuario())
                        intent.putExtra("datos",bundle)
                        startActivity(intent)
                    }
                    notificacion.show()
                }
            }

            binding.botonVaciar.id -> {
                limpiarDatos()
            }
        }
    }

    private fun limpiarDatos() {
        binding.editNombre.text.clear()
        binding.editCorreo.text.clear()
        binding.editPass.text.clear()
        binding.checkRecordar.isChecked = false
    }
}