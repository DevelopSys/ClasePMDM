package com.example.tienda

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.helper.widget.Grid
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tienda.adapter.AdapterProducto
import com.example.tienda.databinding.ActivityMainBinding
import com.example.tienda.dataset.DataSet
import com.example.tienda.model.Producto

class MainActivity : AppCompatActivity(), AdapterProducto.OnProductoListener {

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


    }

    // representar el menu en la parte superior derecha
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    // gestiono la logica de cada pulsacion de los elementos del menu
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.menuTotal->{}
            R.id.menuInformacion->{}
            R.id.menuCarrito->{}
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCompraProductoSelected() {
        binding.textoCarrito.text = DataSet.listaFavs.size.toString()
    }

}