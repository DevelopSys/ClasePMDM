package com.example.saludo

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.saludo.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(), View.OnClickListener {

    // private lateinit var editNombre: EditText

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        this.setContentView(binding.root)
        // editNombre = this.findViewById(R.id.editNombre)
        /*
        binding.buttonSaludar.setOnClickListener{
            // it quien ha generado el evento-> buttonSaludar
            Log.v("info","boton saludar pulsado correctamente")
        }
        binding.buttonSalir.setOnClickListener{
            // it quien ha generado el evento-> buttonSaludar
            Log.v("info","boton salir pulsado correctamente")
        }*/
        binding.buttonSaludar.setOnClickListener(this)
        binding.buttonSalir.setOnClickListener(this)
        binding.buttonLimpiar.setOnClickListener(this)
        Log.v("ciclo_vida", "Ejecutando el metodo onCreate")
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            binding.buttonLimpiar.id -> {
                binding.editNombre.text.clear()
            }

            binding.buttonSaludar.id -> {
                val nombre: String = binding.editNombre.text.toString()

                if (binding.editNombre.text.isEmpty()) {
                    Snackbar.make(
                        p0,
                        "No hay nombre en la caja de texto",
                        Snackbar.LENGTH_LONG
                    ).show()
                } else {
                    val notificacion = Snackbar.make(
                        p0,
                        "Enhorabuena ${binding.editNombre.text.toString()} has completado la tarea",
                        Snackbar.LENGTH_INDEFINITE
                    )
                    notificacion.setAction("Cerrar") { notificacion.dismiss() }
                    notificacion.show()
                }

            }

            binding.buttonSalir.id -> {
                finish()
            }
        }
    }

    override fun onStart() {
        super.onStart()
        Log.v("ciclo_vida", "Ejecutando el metodo onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.v("ciclo_vida", "Ejecutando el metodo onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.v("ciclo_vida", "Ejecutando el metodo onPause")

    }

    override fun onStop() {
        super.onStop()
        Log.v("ciclo_vida", "Ejecutando el metodo onStop")

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.v("ciclo_vida", "Ejecutando el metodo onDestroy")

    }

    override fun onRestart() {
        super.onRestart()
        Log.v("ciclo_vida", "Ejecutando el metodo onRestart")

    }
}