package com.example.examenetiquetas

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.examenetiquetas.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        acciones()
    }

    private fun acciones() {
        binding.spinnerCombustible.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    when (binding.spinnerCombustible.selectedItem.toString()) {
                        "Hibrido" -> {
                            binding.editAutonomia.isEnabled = true
                            binding.editAnio.setText("2018")
                            binding.editAnio.isEnabled = false
                        }

                        "Electrico" -> {
                            binding.editAutonomia.isEnabled = false
                            binding.editAnio.setText("2018")
                            binding.editAnio.isEnabled = false
                        }

                        else -> {
                            binding.editAnio.isEnabled = true
                            binding.editAutonomia.setText("")
                            binding.editMatricula.setText("")
                            binding.editAutonomia.isEnabled = false
                        }
                    }
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                }

            }
        binding.botonConsulta.setOnClickListener {
            if (binding.editNombre.text.isNotEmpty()
                && binding.editMatricula.text.isNotEmpty()
                && binding.editApellido.text.isNotEmpty()
                && binding.editAnio.text.isNotEmpty()
            ) {
                val intent: Intent = Intent(this, SecondActivity::class.java);
                intent.putExtra(
                    "coche", Coche(
                        nombre = binding.editNombre.text.toString(),
                        apellido = binding.editApellido.text.toString(),
                        anio = binding.editAnio.text.toString().toInt(),
                        matricula = binding.editMatricula.text.toString(),
                        combustible = binding.spinnerCombustible.selectedItem.toString(),
                        autonomia = binding.editAutonomia.text.toString().toInt()
                    )
                )
                startActivity(intent)
            } else {
                Snackbar.make(binding.root, "Faltan datos", Snackbar.LENGTH_SHORT).show()
            }
        }
    }
}