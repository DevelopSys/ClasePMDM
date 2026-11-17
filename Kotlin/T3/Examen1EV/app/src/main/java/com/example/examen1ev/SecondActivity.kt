package com.example.examen1ev

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.examen1ev.databinding.ActivitySecondBinding
import com.example.examen1ev.model.Alumno

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding
    private lateinit var alumno: Alumno
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        alumno = intent.getSerializableExtra("alumno") as Alumno
        binding.txtNombre.text = alumno.nombre
        binding.txtN1.text = alumno.n1.toString()
        binding.txtFFE.text = alumno.ffe.toString()
        val media = (alumno.n1 + alumno.n2 + alumno.n3) / 3
        if (media >= 5 && alumno.tfg && alumno.ffe) {
            binding.txtResult.text = resources.getString(R.string.text_course)
            binding.imagen.setImageResource(R.drawable.contento)
        } else {
            binding.txtResult.text = resources.getString(R.string.text_course_fail)
            binding.imagen.setImageResource(R.drawable.triste)
        }

    }
}