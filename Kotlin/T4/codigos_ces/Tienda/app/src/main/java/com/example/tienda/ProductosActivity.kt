package com.example.tienda

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.tienda.adapters.AdaptadorProductos
import com.example.tienda.adapters.AdaptadorProductosJSON
import com.example.tienda.databinding.ActivityProductosBinding
import com.example.tienda.model.Producto
import com.google.gson.Gson
import org.json.JSONArray
import org.json.JSONObject

class ProductosActivity : AppCompatActivity(), AdaptadorProductosJSON.OnProductoListener {

    private lateinit var adaptadorProductosJSON: AdaptadorProductosJSON
    private lateinit var binding: ActivityProductosBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductosBinding.inflate(layoutInflater)
        setContentView(binding.root)
        adaptadorProductosJSON = AdaptadorProductosJSON(this, {})
        binding.recyclerProductos.adapter = adaptadorProductosJSON
        binding.recyclerProductos.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)


        // 1- creo la peticion
        val url: String = "https://dummyjson.com/products"
        val peticion: JsonObjectRequest =
            JsonObjectRequest(url, { procesarPeticion(it) }, { })
        /*val peticion: JsonObjectRequest =
            JsonObjectRequest()*/

        Volley.newRequestQueue(applicationContext).add(peticion)
    }

    private fun procesarPeticion(respuesta: JSONObject) {
        val gson: Gson = Gson()
        val productos: JSONArray = respuesta.getJSONArray("products")
        for (i in 0..productos.length() - 1) {
            val productoJSON: JSONObject = productos.getJSONObject(i)
            val producto = gson.fromJson(productoJSON.toString(), Producto::class.java)
            adaptadorProductosJSON.agregarProducto(producto)
            // Log.v("datos", producto.getString("title"))
        }
    }

    override fun onProductoSelected(producto: Producto) {

    }
}