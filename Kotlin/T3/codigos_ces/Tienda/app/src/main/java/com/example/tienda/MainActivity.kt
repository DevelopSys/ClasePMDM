package com.example.tienda

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem

import android.view.View
import android.widget.AdapterView

import androidx.appcompat.app.AppCompatActivity

import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tienda.adapter.AdapterProducto
import com.example.tienda.databinding.ActivityCarritoBinding
import com.example.tienda.databinding.ActivityMainBinding
import com.example.tienda.dataset.DataSet
import com.example.tienda.model.Producto
import com.example.tienda.ui.activities.CarritoActivity
import com.example.tienda.ui.dialogs.DIalogoComparar
import com.example.tienda.ui.dialogs.DialogoInformacion
import com.example.tienda.ui.dialogs.DialogoResultado
import com.google.android.material.snackbar.Snackbar
import java.util.Locale

class MainActivity : AppCompatActivity(),
    AdapterProducto.OnProductoCarritoListener,
    DIalogoComparar.OnCompararListener {

    private var producto1: Producto? = null
    private var producto2: Producto? = null
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapterProducto: AdapterProducto
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        val lista: ArrayList<Producto> = DataSet.lista
        // quiero obtener la lista de productos de una categoria determinada
        // categoria

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

        // acciones()


    }

    fun acciones() {
        binding.spinnerCategorias.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    var categoriaSeleccionada = parent!!.adapter.getItem(position)
                    var listaFiltrada = DataSet.getListaFiltrada(
                        categoriaSeleccionada.toString().lowercase(
                            Locale.ROOT
                        )
                    )
                    adapterProducto.chageList(listaFiltrada)
                    // adapterProducto = AdapterProducto(listaFiltrada, this@MainActivity)
                    // binding.recyclerProductos.adapter = adapterProducto;
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {

                }
            }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.manu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            // ver la activity del carrito
            R.id.menu_carrio -> {
                val intent = Intent(this, CarritoActivity::class.java)
                startActivity(intent)
            }
            // fitrar la lista (no se filtra por el cambio)
            R.id.menu_filtrar -> {
                val seleccionSpinner = binding.spinnerCategorias.selectedItem.toString()
                val lista = DataSet.getListaFiltrada(seleccionSpinner)
                adapterProducto.chageList(lista)
            }
            // quito el filtro de la lista, y pongo todos los elementos
            R.id.menu_limpiar -> {
                val lista = DataSet.getListaFiltrada("todas")
                adapterProducto.chageList(lista)
            }

            R.id.menu_info -> {
                val dialogoInformacion: DialogoInformacion = DialogoInformacion()
                dialogoInformacion.show(supportFragmentManager, null)
            }

            R.id.menu_comparar -> {
                val dialogoComparar = DIalogoComparar()
                dialogoComparar.show(supportFragmentManager, null)
            }
        }
        return true;
    }

    override fun onRestart() {
        super.onRestart()
        actualizarContadorCarrito()
    }

    override fun actualizarContadorCarrito() {
        binding.textoContador.text = DataSet.listaCarrito.size.toString()
    }

    override fun compararProducto(producto: Producto) {
        if (producto1 == null) {
            producto1 = producto;
        } else if (producto2 == null) {
            producto2 = producto;
        } else {
            /*producto2 = producto1
            producto1 = producto*/
            Snackbar.make(
                binding.root, "No hay espacio para comprar",
                Snackbar.LENGTH_SHORT
            ).show()
        }
    }

    override fun onCompararSelected(opcion: String) {
        Snackbar.make(binding.root, "La opcion seleccionada es ${opcion}", Snackbar.LENGTH_SHORT)
            .show()

        val dialogo = DialogoResultado.newInstance(producto1!!,producto2!!, opcion)
        dialogo.show(supportFragmentManager,null)
    }
}