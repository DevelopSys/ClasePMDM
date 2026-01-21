package com.example.agendajson

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.agendajson.adapter.AdapterUser
import com.example.agendajson.databinding.ActivityMainBinding
import com.example.agendajson.model.Usuario
import com.example.agendajson.ui.dialog.DialogAyuda
import com.example.agendajson.ui.dialog.DialogFiltrar
import com.example.agendajson.ui.dialog.DialogUser
import com.google.android.material.snackbar.Snackbar
import com.google.gson.Gson
import org.json.JSONArray
import org.json.JSONObject

class MainActivity : AppCompatActivity()
    , DialogFiltrar.OnDialogoGeneroListener
    , AdapterUser.OnUserAdapterListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapterUser: AdapterUser
    private val urlBase: String = "https://dummyjson.com/users"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        instancias()
        initGUI()
        realizarPeticionJSON(urlBase)
    }

    private fun initGUI() {
        binding.recyclerUsuarios.adapter = adapterUser;
        binding.recyclerUsuarios.layoutManager =
            LinearLayoutManager(
                this, LinearLayoutManager.VERTICAL,
                false
            )
    }

    private fun instancias() {
        adapterUser = AdapterUser(this)
    }

    private fun realizarPeticionJSON(url: String?) {

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
            val usuario: Usuario = gson.fromJson(
                usuarioJSON.toString(),
                Usuario::class.java
            )
            adapterUser.addUser(usuario)


            Log.v("conexion", usuario.firstName.toString())
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_filtrar -> {
                val dialogoFiltrar: DialogFiltrar = DialogFiltrar()
                dialogoFiltrar.show(supportFragmentManager, null)
            }

            R.id.menu_ayuda -> {
                // crea un objeto de la clase
                val dialogoAyuda = DialogAyuda()
                dialogoAyuda.show(supportFragmentManager, null)
                /*val dialogoDetalle: DialogUser = DialogUser()
                dialogoDetalle.show(supportFragmentManager,null)*/
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onGeneroSelected(genero: String) {

        adapterUser.clearUsers()
        if (genero.equals("all")) {
            realizarPeticionJSON(urlBase)
        } else {
            realizarPeticionJSON("$urlBase/filter?key=gender&value=$genero")
        }
    }

    override fun onDetailSelected(usuario: Usuario) {
        val dialogo: DialogUser = DialogUser.newInstance(usuario)
        dialogo.show(supportFragmentManager, null)
    }

}