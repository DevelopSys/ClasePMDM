package com.example.calculadorarepaso

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.calculadorarepaso.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.botonCalcular.setOnClickListener {

            if (!binding.editOperandoUno.text.isEmpty() && !binding.editOperandoDos.text.isEmpty()) {

                // captura los elementos de los edit
                val operandoUno = binding.editOperandoUno.text.toString().toInt()
                val operandoDos = binding.editOperandoDos.text.toString().toInt()
                // captura el tipo de operacion
                val operacion = binding.spinnerOperaciones.selectedItem.toString()
                // opera
                var resultado = 0;
                when (operacion) {
                    "suma" -> {
                        resultado = operandoUno + operandoDos
                    }

                    "resta" -> {
                        resultado = operandoUno - operandoDos
                    }

                    "multiplicacion" -> {
                        resultado = operandoUno * operandoDos
                    }

                    "division" -> {
                        resultado = operandoUno / operandoDos
                    }
                }
                // pon resultado en el textview
                binding.textoResultado.text = resultado.toString()
            } else {
                Snackbar.make(binding.root, "No hay datos para operar", Snackbar.LENGTH_SHORT)
                    .show()
            }

        }
    }
}