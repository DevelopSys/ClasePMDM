package com.example.tienda

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.helper.widget.Grid
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tienda.adapter.AdapterProducto
import com.example.tienda.databinding.ActivityMainBinding
import com.example.tienda.model.Producto

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapterProducto: AdapterProducto
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val lista: ArrayList<Producto> =
            arrayListOf(
                Producto(1, "Nombre1", 112, 10.0, "descripcion1", "muebles", ""),
                Producto(2, "Nombre2", 212, 20.0, "descripcion2", "muebles", ""),
                Producto(2, "Nombre2", 312, 30.0, "descripcion3", "muebles", ""),
                Producto(2, "Nombre2", 412, 40.0, "descripcion4", "muebles", ""),
                Producto(2, "Nombre2", 512, 50.0, "descripcion5", "muebles", ""),
                Producto(2, "Nombre2", 612, 60.0, "descripcion6", "muebles", ""),
                Producto(2, "Nombre2", 712, 70.0, "descripcion7", "muebles", ""),
                Producto(2, "Nombre2", 812, 80.0, "descripcion8", "muebles", ""),
                Producto(2, "Nombre2", 912, 90.0, "descripcion9", "muebles", ""),
                Producto(2, "Nombre2", 1112, 100.0, "descripcion10", "muebles", ""),
                Producto(2, "Nombre2", 1212, 110.0, "descripcion11", "muebles", ""),
                Producto(2, "Nombre2", 1312, 120.0, "descripcion12", "muebles", ""),
                Producto(2, "Nombre2", 1412, 130.0, "descripcion13", "muebles", ""),
                Producto(2, "Nombre2", 1512, 140.0, "descripcion14", "muebles", ""),

                )
        adapterProducto = AdapterProducto(lista, this)

        if (resources.configuration.orientation == 1) {
            binding.recyclerProductos.layoutManager =
                LinearLayoutManager(
                    this,
                    LinearLayoutManager.VERTICAL, false
                )
        } else {

            binding.recyclerProductos.layoutManager =
                GridLayoutManager(
                    this, 2,
                    GridLayoutManager.VERTICAL, false
                )
        }
        binding.recyclerProductos.adapter = adapterProducto;


    }
}