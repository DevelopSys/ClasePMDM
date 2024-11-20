package com.example.pizzeria

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import android.widget.CompoundButton
import android.widget.CompoundButton.OnCheckedChangeListener
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.pizzeria.adapter.AdapterIngrediente
import com.example.pizzeria.databinding.ActivityMainBinding
import com.example.pizzeria.model.Alergeno
import com.example.pizzeria.model.Ingrediente
import com.example.pizzeria.model.Pizza
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var listaPizza: ArrayList<Pizza>
    private lateinit var adapterPizzas: ArrayAdapter<Pizza>
    private lateinit var adapterIngrediente: AdapterIngrediente
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        instancias()
        acciones()

    }

    private fun acciones() {
        binding.spinnerPizzas.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                val pizza = adapterPizzas.getItem(p2)
                binding.toggleDisponibilidad.isChecked = pizza!!.estado
                adapterIngrediente.changeList(pizza.ingredientes)
                // pizza.ingredientes
                // adapterIngrediente = AdapterIngrediente(pizza.ingredientes,applicationContext)
                // binding.listViewIngredientes.adapter = adapterIngrediente
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }

        }
        binding.toggleDisponibilidad.setOnCheckedChangeListener { _, b ->
            binding.btnPedido.isEnabled = b
        }
        /*binding.listViewIngredientes.setOnItemClickListener { _, _, i, _ ->
            // nueva pantalla con el detalle del ingrediente pulsado
            Snackbar.make(
                binding.root,
                "El ingrediente seleccionado es ${adapterIngrediente.getItem(i).nombre}",
                Snackbar.LENGTH_SHORT
            ).show()

        }*/
        binding.listViewIngredientes.setOnItemLongClickListener { _, _, i, _ ->
            /*Snackbar.make(
                binding.root,
                "El ingrediente seleccionado es ${i.toString()}",
                Snackbar.LENGTH_SHORT
            ).show()*/
            adapterIngrediente.removeIng(i)
            return@setOnItemLongClickListener true
        }
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
        adapterPizzas =
            ArrayAdapter(
                applicationContext, android.R.layout.simple_spinner_item,
                listaPizza
            )
        adapterPizzas.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerPizzas.adapter = adapterPizzas

        val pizzaSeleccionada = adapterPizzas
            .getItem(binding.spinnerPizzas.selectedItemPosition)
        adapterIngrediente =
            AdapterIngrediente(
                pizzaSeleccionada!!.ingredientes,
                applicationContext
            )
        binding.listViewIngredientes.adapter = adapterIngrediente;
        adapterIngrediente.notifyDataSetChanged()
        // binding.listViewIngredientes.adapter = adapterIngrediente
    }


}