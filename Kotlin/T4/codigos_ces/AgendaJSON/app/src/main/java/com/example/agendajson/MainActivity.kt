package com.example.agendajson

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.agendajson.adapter.UserAdapter
import com.example.agendajson.databinding.ActivityMainBinding
import com.example.agendajson.model.User
import com.example.agendajson.ui.dialog.DialogFilter
import com.example.agendajson.ui.dialog.DialogUser
import com.google.android.material.snackbar.Snackbar
import com.google.gson.Gson
import org.json.JSONArray
import org.json.JSONObject

class MainActivity : AppCompatActivity(),
    DialogFilter.OnDialogoFiltrarListener, UserAdapter.OnItemUserListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: UserAdapter
    private val urlBase = "https://dummyjson.com/users"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        instancias()
        initGUI()
        realizarPeticionJSON(urlBase)
    }

    private fun instancias() {
        adapter = UserAdapter(this)
    }

    private fun initGUI() {

        setSupportActionBar(binding.toolbar)
        binding.recyclerUsers.adapter = adapter;
        binding.recyclerUsers.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }

    private fun realizarPeticionJSON(url: String) {

        // 1. Realizar la peticion de forma correcta
        val peticionJSON: JsonObjectRequest = JsonObjectRequest(
            url,
            {
                val gson = Gson()
                val usersArray: JSONArray = it.getJSONArray("users")
                for (i in 0..usersArray.length() - 1) {
                    val userJSON = usersArray.getJSONObject(i)
                    val user: User = gson.fromJson(
                        userJSON.toString(),
                        User::class.java
                    )
                    adapter.addUSer(user)
                }
                //Log.v("conexion","Los datos se obtienen de forma correcta")
            },
            {
                Log.v("conexion", "Error en la conexion")
            })
        // 2. Añado la peticion a la pila de Volley
        Volley.newRequestQueue(this).add(peticionJSON)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.menu_filtrar -> {
                val dialogFilter: DialogFilter = DialogFilter()
                dialogFilter.show(supportFragmentManager, null)
            }
        }

        return super.onOptionsItemSelected(item)
    }

    override fun onGeneroSelected(genero: String) {
        // Snackbar.make(binding.root, "El genero seleccionado es $genero", Snackbar.LENGTH_SHORT).show()
        // PETICION JSON CON UNA URL ALGO DIFERENTE
        adapter.clearUsers()
        if (genero == "all")
            realizarPeticionJSON(urlBase)
        else {
            val urlGender = "$urlBase/filter?key=gender&value=$genero"
            realizarPeticionJSON(urlGender)
        }
    }

    override fun onUserDetailSelected(user: User) {
        val dialogo: DialogUser = DialogUser.newInstance(user)
        dialogo.show(supportFragmentManager, null)
    }


}

