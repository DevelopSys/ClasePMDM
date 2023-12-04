package com.example.t3_listajson

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.android.volley.Request.Method
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.t3_listajson.model.User
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // creo la peticion
        val url = "https://randomuser.me/api/?results=50"
        val peticion: JsonObjectRequest = JsonObjectRequest(url, {
            getUsers(it)
        }, {

        })
        //val peticion2: JsonObjectRequest = JsonObjectRequest(Method.GET,url,null,{},{})
        // lanzar la peticion
        Volley.newRequestQueue(applicationContext).add(peticion)
    }

    fun getUsers(response: JSONObject): Unit {
        // crear clase modelo User
        // obtener una lista de todos los usuarios del JSON
        val results = response.getJSONArray("results")
        for(i in (0..results.length()-1)){
            val user = results.getJSONObject(i);
            val name = user.getJSONObject("name").getString("first")
            val last = user.getJSONObject("name").getString("last")
            val phone = user.getString("phone");
            val email = user.getString("email");
            val image = user.getJSONObject("picture").getString("medium")
            val country = user.getJSONObject("location").getString("country")
            val postCode = user.getJSONObject("location").getInt("postcode")
            val city = user.getJSONObject("location").getString("city")
            val usuario = User(name,last,email,phone,postCode,country,city,image)

        }
        // nombre, apellido, telefono, pais, ciudad, codigo postal, mail

    }
}