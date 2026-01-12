package com.example.agendajson

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.agendajson.databinding.ActivityMainBinding
import com.example.agendajson.model.Usuario
import com.google.gson.Gson
import com.google.gson.JsonArray
import org.json.JSONArray
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        realizarPeticionJSON()


    }

    private fun realizarPeticionJSON() {
        val url = "https://dummyjson.com/users"
        // 1 - crear la peticion -> JSONObjectRequest
        val request: JsonObjectRequest =
            JsonObjectRequest(
                url,
                { procesarRespuesta(it) },
                { Log.v("error", "Error en la conxion") })
        // 2 - Añadir a la cola de peticiones
        Volley.newRequestQueue(applicationContext).add(request)
    }


    private fun procesarRespuesta(param: JSONObject) {
        val gson: Gson = Gson()
        val usuariosJSONArray: JSONArray = param.getJSONArray("users")
        for (i in 0..usuariosJSONArray.length() - 1) {
            val usuarioJSON: JSONObject = usuariosJSONArray.getJSONObject(i)
            val usuario: Usuario = gson.fromJson(usuarioJSON.toString(),
                Usuario::class.java)
            Log.v("conexion", usuario.firstName.toString())
        }

    }


}