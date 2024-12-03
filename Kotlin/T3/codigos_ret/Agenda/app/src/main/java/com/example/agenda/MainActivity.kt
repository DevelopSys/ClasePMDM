package com.example.agenda

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

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val url: String = "https://dummyjson.com/users"
        val peticion: JsonObjectRequest = JsonObjectRequest(url, {
            procesarRespuesta(it)
        },
            {
                Log.v("conexion", "conexion incorrecta")
            })
        Volley.newRequestQueue(applicationContext).add(peticion)

    }

    private fun procesarRespuesta(respuesta: JSONObject){
        val users: JSONArray = respuesta.getJSONArray("users")
        for (i in 0..users.length()-1){
            val user: JSONObject = users.getJSONObject(i)
            val fistName: String = user.getString("firstName")
            Log.v("usuarios", fistName)
        }
    }
}