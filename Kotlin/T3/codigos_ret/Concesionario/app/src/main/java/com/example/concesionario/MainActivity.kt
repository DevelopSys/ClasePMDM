package com.example.concesionario

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.concesionario.databinding.ActivityMainBinding
import com.example.concesionario.model.Marca
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    // arraylist -> datos a mostrar
    private lateinit var listaMarca: ArrayList<Marca>
    // adapter -> elemento que acompla los datos al spinner

    private lateinit var binding: ActivityMainBinding;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        instancias()

    }

    private fun instancias() {
        listaMarca = arrayListOf(
            Marca("Mercedes", R.drawable.mercedes),
            Marca("Audi", R.drawable.audi),
            Marca("BMW", R.drawable.bmw),
            Marca("BYD", R.drawable.byd),
            Marca("Ford", R.drawable.ford),
        )
    }
}