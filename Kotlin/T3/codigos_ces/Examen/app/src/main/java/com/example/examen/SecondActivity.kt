package com.example.examen

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.examen.databinding.ActivitySecondBinding
import com.example.examen.model.Coche

class SecondActivity : AppCompatActivity() {


    private lateinit var coche: Coche;
    private lateinit var binding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        coche = intent.getSerializableExtra("coche") as Coche
        initGUI()


    }

    private fun initGUI() {

        if (coche.combustible == "electrico" || (coche.combustible == "hibrido" && coche.autonomia > 80)) {
            binding.imagenEtiqueta.setImageResource(R.drawable.ic_launcher_background)
        } else if (coche.combustible == "hibrido") {

        } else if (coche.combustible == "diesel" && coche.anio > 2006 && coche.anio < 2015 || (coche.combustible == "gasolina" && coche.anio > 2008 && coche.anio < 2017)) {

        } else {

        }

    }
}