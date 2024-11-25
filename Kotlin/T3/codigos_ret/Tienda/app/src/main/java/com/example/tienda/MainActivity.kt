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

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adaptadorProducto: ProductoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        instancias()
    }

    private fun instancias() {
        adaptadorProducto = ProductoAdapter(DataSet.listaProductos, this)

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
}