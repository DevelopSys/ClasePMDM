package com.example.agenda

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
import com.bumptech.glide.Glide
import com.example.agenda.adapter.AdapterUsuarios
import com.example.agenda.databinding.ActivityMainBinding
import com.example.agenda.model.Usuario
import com.google.gson.Gson
import org.json.JSONArray
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapterUsuarios: AdapterUsuarios

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        instancias()
        val url: String = "https://dummyjson.com/users"
        val peticion: JsonObjectRequest = JsonObjectRequest(url, {
            procesarRespuesta(it)
        },
            {
                Log.v("conexion", "conexion incorrecta")
            })
        Volley.newRequestQueue(applicationContext).add(peticion)

    }

    private fun instancias() {
        adapterUsuarios = AdapterUsuarios(this)
        binding.recyclerUsuarios.adapter = adapterUsuarios
        binding.recyclerUsuarios.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }

    private fun procesarRespuesta(respuesta: JSONObject) {
        val users: JSONArray = respuesta.getJSONArray("users")
        val gson = Gson()
        for (i in 0..users.length() - 1) {
            val user: JSONObject = users.getJSONObject(i)
            val userKT = gson.fromJson(user.toString(), Usuario::class.java)
            adapterUsuarios.addUser(userKT)
            // val fistName: String = user.getString("firstName")
            // Log.v("usuarios", userKT.firstName)
        }
    }
}