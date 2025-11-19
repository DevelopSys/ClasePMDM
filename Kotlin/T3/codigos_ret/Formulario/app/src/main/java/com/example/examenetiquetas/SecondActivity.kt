package com.example.examenetiquetas

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.examenetiquetas.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding
    private var coche: Coche? = null;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        recuperarDatos();
        initGUI()
    }

    private fun initGUI() {

        binding.textApellido.setText(coche!!.apellido)
        binding.textAutonomia.setText(coche!!.autonomia!!.toString())
        binding.textAnio.setText(coche!!.anio)
        binding.textNombre.setText(coche!!.nombre)
        binding.textCombustible.setText(coche!!.combustible)
        binding.textMatricula.setText(coche!!.matricula)
        if (coche!!.combustible.equals("Electrico", true)
            || (coche!!.combustible.equals("Hibrido", true) && coche!!.autonomia!! > 80)
        ) {
            binding.imagenEtiqueta.setImageResource(R.drawable.etiqueta0)
        }else if (coche!!.combustible.equals("Hibrido", true) && coche!!.autonomia!! < 80) {
            binding.imagenEtiqueta.setImageResource(R.drawable.etiquetaeco)
        }

        else if (coche!!.combustible.equals(
                "Diesel",
                true
            ) && coche!!.anio > 2006 && coche!!.anio < 2015 || (coche!!.combustible.equals(
                "Gasolina",
                true
            ) && coche!!.anio > 2008 && coche!!.anio < 2017)
        ) {
            binding.imagenEtiqueta.setImageResource(R.drawable.etiquetac)
        } else {
            binding.imagenEtiqueta.setImageResource(R.drawable.etiquetab)
        }
    }

    private fun recuperarDatos() {
        coche = intent.getSerializableExtra("coche") as Coche
    }
}