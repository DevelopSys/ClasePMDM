package com.example.t3_listaapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.android.volley.Request.Method
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import org.json.JSONArray
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val url = "https://randomuser.me/api/?results=50"
        // JSONRequest = ctx, url, meth, json, respuesta ok, respuesta err
        val jsonRequest = JsonObjectRequest(url,
            {
                // lo que ejecuto cuando la conexion es ok
                //Log.v("conexion", "conexion ok")
                precesarResponse(it)
            },
            {
                // lo que ejecuto cuando la conexion es no ok
                Log.v("conexion", "conexion incorrecta")
            })
        /*val jsonRequest = JsonObjectRequest(Method.GET,url,null,
            {
                // lo que ejecuto cuando la conexion es ok
            },
            {
                // lo que ejecuto cuando la conexion es no ok
            })*/

        // Vollet. add request
        Volley.newRequestQueue(applicationContext).add(jsonRequest)

    }

    fun precesarResponse(response: JSONObject): Unit {
            val results = response.getJSONArray("results")
            for (i in 0..results.length()-1){
                val user = results.getJSONObject(i)
                val email = user.getString("email");
                Log.v("conexion",email)
            }
    }
}