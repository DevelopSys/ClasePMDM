package com.example.pizzeria

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.pizzeria.databinding.ActivityMainBinding
import com.example.pizzeria.model.Alergeno
import com.example.pizzeria.model.Ingrediente
import com.example.pizzeria.model.Pizza

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var listaPizza: ArrayList<Pizza>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        instancias()

    }

    private fun instancias() {

        /*
        var nombre: String,
    var info: String,
    var ingredientes: ArrayList<Ingrediente>,
    var estado: Boolean,
    var imagen: Int
         */
        listaPizza = arrayListOf(
            Pizza(
                "Carbonara", "800Kcal", arrayListOf(
                    Ingrediente(
                        "Champiñones", R.drawable.champi, "30Kcal", 0.50,
                        arrayListOf(
                            Alergeno("trigo", R.drawable.champi),
                            Alergeno("trigo", R.drawable.champi)
                        ),
                    )
                ), true, R.drawable.carbonara
            ),
            Pizza(
                "Barbacoa", "1000Kcal", arrayListOf(
                    Ingrediente(
                        "Carne", R.drawable.champi, "300Kcal", 2.50,
                        arrayListOf(
                            Alergeno("trigo", R.drawable.champi),
                            Alergeno("trigo", R.drawable.champi)
                        ),

                        ), Ingrediente(
                        "Salsa", R.drawable.champi, "200Kcal", 3.50,
                        arrayListOf(
                            Alergeno("trigo", R.drawable.champi),
                            Alergeno("trigo", R.drawable.champi)
                        ),

                        )
                ), false, R.drawable.carbonara
            )
        )
    }
}