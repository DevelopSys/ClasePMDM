package com.example.t3_listaapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request.Method
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.bumptech.glide.Glide
import com.example.t3_listaapi.adapter.UsuariosAdapter
import com.example.t3_listaapi.databinding.ActivityMainBinding
import com.example.t3_listaapi.model.Direccion
import com.example.t3_listaapi.model.Usuario
import org.json.JSONArray
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    private lateinit var listaUsuario: ArrayList<Usuario>;
    private lateinit var adaptadoUsuariosAdapter: UsuariosAdapter
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        listaUsuario = ArrayList();
        adaptadoUsuariosAdapter = UsuariosAdapter(listaUsuario,this)
        binding.recyclerUsuarios.adapter = adaptadoUsuariosAdapter;
        binding.recyclerUsuarios.layoutManager = LinearLayoutManager(applicationContext,LinearLayoutManager.VERTICAL,false)


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
                val usuario = results.getJSONObject(i)
                val nombre: String = usuario.getJSONObject("name").getString("first")
                val apellido: String = usuario.getJSONObject("name").getString("last")
                val telefono: Long = usuario.getJSONObject("location")
                    .getJSONObject("street").getInt("number")
                    .toLong()
                /*.toString()
                    .replace(" ","")
                    .replace("(","")
                    .replace(")","")
                    .replace("-","").toLong()*/
                val mail: String = usuario.getString("email")
                val imagen: String = usuario.getJSONObject("picture").getString("medium");
                val pais: String = usuario.getJSONObject("location").getString("country")
                val ciudad: String = usuario.getJSONObject("location").getString("city")
                listaUsuario.add(Usuario(nombre,apellido,
                    Direccion(pais,ciudad),telefono,mail, imagen))
                //adaptadoUsuariosAdapter.notifyDataSetChanged()
                adaptadoUsuariosAdapter.notifyItemInserted(listaUsuario.size-1)
            }
    }
}