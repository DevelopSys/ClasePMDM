package com.develop.t3_spinner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.develop.t3_spinner.databinding.ActivityDetailBinding
import com.develop.t3_spinner.modelo.Pais

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        recuperarDatos()

    }

    private fun recuperarDatos() {
        // intent --> bundle --> dato
        var bundle = intent.extras
        var equipo: Pais =  bundle!!.getSerializable("equipo") as Pais
        binding.textoTitulos.setText(equipo.numeroTitulos.toString());
        binding.textoEstrella.setText(equipo.estrella);
        binding.nombreDetalle.setText(equipo.nombre)
        binding.imagenDetalle.setImageResource(equipo.imagen)
    }
}