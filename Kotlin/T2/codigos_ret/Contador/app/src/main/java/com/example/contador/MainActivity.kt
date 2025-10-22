package com.example.contador

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.contador.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(), View.OnClickListener {

    // lateinit var botonIncremen: Button

    lateinit var binding: ActivityMainBinding
    var contador: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        contador = savedInstanceState?.getInt("contador") ?: 0
        binding.textoContador.text = contador.toString()

        // valores grafico + logico
    }

    override fun onResume() {
        super.onResume()
        acciones()
    }

    private fun acciones() {
        binding.botonIncremento.setOnClickListener(this)
        binding.botonDecremento.setOnClickListener(this)
        binding.botonReset?.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        // id
        when (v!!.id) {
            binding.botonIncremento.id -> {
                // sumar uno a lo que hay en el texto
                contador++
            }

            binding.botonDecremento.id -> {
                // restar uno a lo que hay en el texto
                contador--
            }

            binding.botonReset?.id -> {
                if (binding.editReset!!.text.isEmpty()) {
                    Snackbar.make(v, "Por favor introduce datos",
                        Snackbar.LENGTH_LONG).show()
                } else {
                    contador = binding.editReset!!.text.toString().toInt();
                }
            }
        }
        binding.textoContador.text = contador.toString()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("contador", contador)
    }
}