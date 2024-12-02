package com.example.tienda

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tienda.adapter.ProductoAdapter
import com.example.tienda.database.DataSet
import com.example.tienda.databinding.ActivityMainBinding
import com.example.tienda.model.Producto
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(), ProductoAdapter.OnProductoListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adaptadorProducto: ProductoAdapter
    private var productoComparar1: Producto? = null
    private var productoComparar2: Producto? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        instancias()
        acciones()
    }

    private fun acciones() {
        //binding.recyclerProductos.seTON
    }

    private fun instancias() {
        adaptadorProducto = ProductoAdapter(DataSet.listaProductos, this) /*{ pos, pro ->
            {
                Snackbar.make(binding.root, "Elemento pulsado ${pos}", Snackbar.LENGTH_SHORT).show()
            }
        }*/

        binding.recyclerProductos.adapter = adaptadorProducto

        if (resources.configuration.orientation == 1) {
            binding.recyclerProductos.layoutManager =
                LinearLayoutManager(
                    applicationContext, LinearLayoutManager.VERTICAL,
                    false
                )
        } else if (resources.configuration.orientation == 2) {
            binding.recyclerProductos.layoutManager =
                GridLayoutManager(applicationContext, 2, GridLayoutManager.VERTICAL, false)
        }

        /*binding.recyclerProductos.layoutManager = GridLayoutManager(applicationContext,2, GridLayoutManager.HORIZONTAL, false)*/
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.salir_menu -> {
                finish()
            }

            R.id.info_menu -> {}
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onProductoSelected(producto: Producto) {

        if (productoComparar1 == null) {
            productoComparar1 = producto;
            Snackbar.make(
                binding.root,
                "Comparacion de productos actualizada",
                Snackbar.LENGTH_SHORT
            )
                .show()
        } else {
            if (producto == productoComparar1 || producto == productoComparar2) {
                Snackbar.make(
                    binding.root,
                    "Por favor selecciona otro producto",
                    Snackbar.LENGTH_SHORT
                ).show()
            } else {
                if (productoComparar2 == null) {
                    productoComparar2 = productoComparar2;
                    Snackbar.make(binding.root, "Comparacion disponible", Snackbar.LENGTH_SHORT)
                        .show()
                } else {
                    productoComparar1 = productoComparar2
                    productoComparar2 = producto;
                    Snackbar.make(binding.root, "Comparacion disponible", Snackbar.LENGTH_SHORT)
                        .show()
                }
            }
        }


    }
}