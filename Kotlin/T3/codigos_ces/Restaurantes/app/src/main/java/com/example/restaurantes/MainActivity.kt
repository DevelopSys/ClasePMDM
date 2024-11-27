package com.example.restaurantes

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.restaurantes.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnAcceder.setOnClickListener {

            val puntuacion = binding.spinnerValoracion.selectedItem.toString().toInt();
            val localidad = binding.spinnerUbicacion.selectedItem.toString()
            val comida = binding.spinnerComida.selectedItem.toString()

            val intent = Intent(this, RestaurantesActivity::class.java);
            val bundle = Bundle();
            bundle.putInt("valoracion", puntuacion)
            bundle.putString("comida", comida)
            bundle.putString("localidad", localidad)
            intent.putExtra("bundle", bundle)
            startActivity(intent)

        }
    }
}