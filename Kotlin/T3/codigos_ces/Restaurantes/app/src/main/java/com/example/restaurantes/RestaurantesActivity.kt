package com.example.restaurantes

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.restaurantes.adapter.AdaptadorRestaurante
import com.example.restaurantes.databinding.ActivityRestaurantesBinding
import com.example.restaurantes.model.Restaurante
import com.google.android.material.snackbar.Snackbar

class RestaurantesActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRestaurantesBinding
    private lateinit var listaRestaurante: ArrayList<Restaurante>
    private lateinit var adaptadorRestaurante: AdaptadorRestaurante
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRestaurantesBinding.inflate(layoutInflater)
        setContentView(binding.root);

        listaRestaurante = arrayListOf(
            Restaurante("Italiano1", "Alcorcon", 6, "italiana", 123, arrayListOf("buena cantidad")),
            Restaurante("Italiano1", "Getafe", 6, "japonesa", 123, arrayListOf("buena cantidad")),
            Restaurante("Italiano1", "Alcrocon", 6, "china", 123, arrayListOf("buena cantidad"))
        )

        val bundle = intent.extras!!.getBundle("bundle")
        val puntuacion = bundle!!.getInt("puntuacion")
        val localidad = bundle!!.getString("localidad")
        val comida = bundle!!.getString("comida")

        val listaFiltrada = listaRestaurante.filter {
            it.comida == comida && it.puntuacion>= puntuacion && it.localidad == localidad
        } as ArrayList<Restaurante>
        adaptadorRestaurante = AdaptadorRestaurante(listaFiltrada,this)
        binding.listViewRestaurantes.adapter = adaptadorRestaurante

        acciones()

    }

    private fun acciones() {
        binding.listViewRestaurantes.setOnItemClickListener { _, _, i, _ ->
            val restaurante = adaptadorRestaurante.getItem(i)
            Snackbar.make(
                binding.root,
                "El telefono es: ${restaurante.telefono}",
                Snackbar.LENGTH_SHORT
            ).show()
        }
    }
}