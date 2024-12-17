package com.example.tienda

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import org.json.JSONArray
import org.json.JSONObject

class ProductosActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_productos)

        // 1- creo la peticion
        val url: String = "https://dummyjson.com/products"
        val peticion: JsonObjectRequest =
            JsonObjectRequest(url, { procesarPeticion(it) }, { })
        /*val peticion: JsonObjectRequest =
            JsonObjectRequest()*/

        Volley.newRequestQueue(applicationContext).add(peticion)
    }

    private fun procesarPeticion(respuesta: JSONObject) {
        val productos: JSONArray = respuesta.getJSONArray("products")
        for (i in 0..productos.length() - 1) {
            val producto: JSONObject = productos.getJSONObject(i)
            Log.v("datos", producto.getString("title"))
        }
    }
}