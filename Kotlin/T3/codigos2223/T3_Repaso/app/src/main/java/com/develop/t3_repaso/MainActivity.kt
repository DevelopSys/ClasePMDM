package com.develop.t3_repaso

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.develop.t3_repaso.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.botonIniciar.setOnClickListener {
            if (binding.editApellido.text.isEmpty() || binding.editNombre.text.isEmpty()) {
                Snackbar.make(binding.botonIniciar,
                    "Faltan datos",
                    Snackbar.LENGTH_SHORT).show()
            } else {
                var intent: Intent = Intent(applicationContext, SecondActivity::class.java)
                var bundle: Bundle = Bundle();
                bundle.putString("nombre", binding.editNombre.text.toString())
                bundle.putString("apellido", binding.editApellido.text.toString())
                intent.putExtras(bundle)
                startActivity(intent)
            }
        }
    }
}