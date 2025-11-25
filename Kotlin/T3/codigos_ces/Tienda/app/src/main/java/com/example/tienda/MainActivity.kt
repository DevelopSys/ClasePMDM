package com.example.tienda

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
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
                Producto(1, "Nombre1", 12, 10.0, "descripcion", "muebles", ""),
                Producto(2, "Nombre2", 12, 10.0, "descripcion", "muebles", ""),
                Producto(2, "Nombre2", 12, 10.0, "descripcion", "muebles", ""),
                Producto(2, "Nombre2", 12, 10.0, "descripcion", "muebles", ""),
                Producto(2, "Nombre2", 12, 10.0, "descripcion", "muebles", ""),
                Producto(2, "Nombre2", 12, 10.0, "descripcion", "muebles", ""),
                Producto(2, "Nombre2", 12, 10.0, "descripcion", "muebles", ""),
                Producto(2, "Nombre2", 12, 10.0, "descripcion", "muebles", ""),
                Producto(2, "Nombre2", 12, 10.0, "descripcion", "muebles", ""),
                Producto(2, "Nombre2", 12, 10.0, "descripcion", "muebles", ""),
                Producto(2, "Nombre2", 12, 10.0, "descripcion", "muebles", ""),
                Producto(2, "Nombre2", 12, 10.0, "descripcion", "muebles", ""),
                Producto(2, "Nombre2", 12, 10.0, "descripcion", "muebles", ""),
                Producto(2, "Nombre2", 12, 10.0, "descripcion", "muebles", ""),

            )
        adapterProducto = AdapterProducto(lista, this)
        binding.recyclerProductos.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.recyclerProductos.adapter = adapterProducto;

    }
}