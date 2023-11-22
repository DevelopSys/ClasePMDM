package com.example.t3_listaproductos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.t3_listaproductos.adapter.AdaptadorProductos
import com.example.t3_listaproductos.databinding.ActivityMainBinding
import com.example.t3_listaproductos.dataset.ProductosDataset
import com.example.t3_listaproductos.model.Producto
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(), AdaptadorProductos.OnRecyclerProductosListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: AdaptadorProductos
    private lateinit var listaProductos: ArrayList<Producto>
    private lateinit var miCesta: ArrayList<Producto>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        listaProductos = savedInstanceState?.getParcelableArrayList("lista")?:ArrayList()
        miCesta = savedInstanceState?.getParcelableArrayList("cesta")?:ArrayList()

        adapter = AdaptadorProductos(listaProductos,this)
        binding.listaProductos.adapter = adapter
        binding.listaProductos.layoutManager =
            LinearLayoutManager(applicationContext,LinearLayoutManager.VERTICAL,false)

        binding.botonAdd.setOnClickListener{
            //listaProductos.add(ProductosDataset.obtenerProducto())
            val producto: Producto = ProductosDataset.obtenerProducto();
            adapter.addProducto(producto)

        }
    }

    override fun onProductoSelected(item: Producto) {
        miCesta.add(item)

        if (miCesta.size == 5){
            val intent = Intent(applicationContext,CestaActivity::class.java)
            intent.putParcelableArrayListExtra("lista",miCesta)
            startActivity(intent)

        } else {
            Snackbar.make(binding.root,"El tamaño de tu cesta es ${miCesta.size}"
                ,Snackbar.LENGTH_SHORT).show()
        }

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putParcelableArrayList("lista", listaProductos)
        outState.putParcelableArrayList("cesta", miCesta)
    }
}