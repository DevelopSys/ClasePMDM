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
import com.example.agendajson.model.User
import com.google.gson.Gson
import org.json.JSONArray
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        realizarPeticionJSON()
    }

    private fun realizarPeticionJSON() {
        val url = "https://dummyjson.com/users"
        // 1. Realizar la peticion de forma correcta
        val peticionJSON: JsonObjectRequest = JsonObjectRequest(
            url,
            {
                val gson = Gson()
                val usersArray: JSONArray = it.getJSONArray("users")
                for (i in 0..usersArray.length() - 1) {
                    val userJSON = usersArray.getJSONObject(i)
                    val user: User = gson.fromJson(userJSON.toString(),
                        User::class.java)

                    Log.v("conexion", "El nombre del usuario es ${user.firstName}")
                }
                //Log.v("conexion","Los datos se obtienen de forma correcta")
            },
            {
                Log.v("conexion", "Error en la conexion")
            })
        // 2. Añado la peticion a la pila de Volley
        Volley.newRequestQueue(this).add(peticionJSON)
    }


}

