package com.example.tienda.ui.activities

import android.os.Bundle
import android.provider.ContactsContract
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tienda.R
import com.example.tienda.adapter.AdapterCarrito
import com.example.tienda.adapter.AdapterProducto
import com.example.tienda.databinding.ActivityCarritoBinding
import com.example.tienda.dataset.DataSet

class CarritoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCarritoBinding
    private lateinit var adapterCarrito: AdapterCarrito

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCarritoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        adapterCarrito = AdapterCarrito(DataSet.listaCarrito, this)
        binding.recycrCarrito.adapter = adapterCarrito;
        binding.recycrCarrito.layoutManager =
            LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false)

        var acumulador = 0
        DataSet.listaCarrito.forEach {
            acumulador = it.precio.toInt() + acumulador;
        }
        binding.textoCarrito.text =acumulador.toString()

    }


}