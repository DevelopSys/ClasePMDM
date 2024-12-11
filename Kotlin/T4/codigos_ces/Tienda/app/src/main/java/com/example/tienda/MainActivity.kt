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
import com.example.tienda.adapters.AdaptadorProductos
import com.example.tienda.data.DataSet
import com.example.tienda.databinding.ActivityMainBinding
import com.example.tienda.model.Producto
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(), AdaptadorProductos.OnProductoListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adaptadorProductos: AdaptadorProductos
    private var producto1: Producto? = null
    private var producto2: Producto? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        instancias()

    }

    private fun instancias() {
        adaptadorProductos = AdaptadorProductos(DataSet.lista, this, {
            Snackbar.make(binding.root, "El precio del producto es $it", Snackbar.LENGTH_SHORT)
                .show()
        })
        binding.recyclerProductos.adapter = adaptadorProductos
        if (resources.configuration.orientation == 1) {
            binding.recyclerProductos.layoutManager =
                LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        } else {
            binding.recyclerProductos.layoutManager =
                GridLayoutManager(this, 2, LinearLayoutManager.VERTICAL, false)
        }
        /*binding.recyclerProductos.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)*/

    }

    override fun onProductoSelected(producto: Producto) {
        /*Snackbar.make(
            binding.root,
            "El producto seleccionadp es ${producto.nombre}",
            Snackbar.LENGTH_SHORT
        ).show()*/
        if (producto1 == null) {
            producto1 = producto
        } else if (producto2 == null) {
            producto2 = producto
        } else {
            producto1 = producto2
            producto2 = producto
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menuComparar -> {
                if (producto1 == null && producto2 == null) {
                    Snackbar.make(
                        binding.root,
                        "No hay productos a comprar",
                        Snackbar.LENGTH_SHORT
                    ).show()
                } else if (producto1 == null || producto2 == null) {
                    Snackbar.make(
                        binding.root,
                        "Te falta un producto a comprar",
                        Snackbar.LENGTH_SHORT
                    ).show()
                } else {
                    Snackbar.make(
                        binding.root,
                        "Listo para cambiar de pantalla",
                        Snackbar.LENGTH_SHORT
                    ).show()
                }
            }
        }
        return super.onOptionsItemSelected(item)
    }
}