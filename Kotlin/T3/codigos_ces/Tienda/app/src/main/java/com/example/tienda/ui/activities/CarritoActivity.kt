package com.example.tienda.ui.activities

import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import android.view.Menu
import android.view.MenuItem
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
import com.example.tienda.ui.dialogs.DialogoConfirmacionCompra
import com.google.android.material.snackbar.Snackbar

class CarritoActivity : AppCompatActivity(),
    DialogoConfirmacionCompra.OnDilogoConfirmacionListener {

    private lateinit var binding: ActivityCarritoBinding
    private lateinit var adapterCarrito: AdapterCarrito
    var acumulador = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCarritoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        supportActionBar?.title = "Carrito"
        adapterCarrito = AdapterCarrito(DataSet.listaCarrito, this)
        binding.recycrCarrito.adapter = adapterCarrito;
        binding.recycrCarrito.layoutManager =
            LinearLayoutManager(
                this,
                LinearLayoutManager.VERTICAL, false
            )


        DataSet.listaCarrito.forEach {
            acumulador = it.precio.toInt() + acumulador;
        }
        binding.textoCarrito.text = acumulador.toString()

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_carrito, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.menu_compra_info -> {}
            R.id.menu_compra -> {
                // saltar un dialogo con el ¿? y los botones de aceptacion
                val dialogoConfirmacionCompra = DialogoConfirmacionCompra()
                dialogoConfirmacionCompra.show(supportFragmentManager, null)
            }

            R.id.menu_pago -> {}
        }

        return super.onOptionsItemSelected(item)
    }

    override fun onConfirmacionSelected() {
        // borrar los productos ->
        // eliminar los productos del recycler -> adapter
        // adapter.notify -> adapter
        // dataset.remove -> desde cualquier lado
        Log.v("comunicacion","comunicacion completada")
        adapterCarrito.limpiarListaCarrito();
        DataSet.listaCarrito.clear()
        Snackbar.make(
            binding.root, "Compra realizada correctamente",
            Snackbar.LENGTH_SHORT
        ).show()


        acumulador =0;
        binding.textoCarrito.text = acumulador.toString()    }






}