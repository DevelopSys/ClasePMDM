package com.example.t3_listajson

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import androidx.fragment.app.DialogFragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request.Method
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.t3_listaapi.adapter.UsuariosAdapter
import com.example.t3_listajson.databinding.ActivityMainBinding
import com.example.t3_listajson.model.User
import com.example.t3_listajson.ui.dialog.FiltradoDialog
import com.example.t3_listajson.ui.dialog.GeneralDialog
import com.example.t3_listajson.ui.dialog.GeneroListaDialog
import com.example.t3_listajson.ui.dialog.GeneroSimpleDialog
import com.example.t3_listajson.ui.dialog.NacionalidadDialog
import com.example.t3_listajson.ui.dialog.VersionDialog
import com.google.android.material.snackbar.Snackbar
import org.json.JSONObject

class MainActivity : AppCompatActivity(), OnItemSelectedListener,
    FiltradoDialog.OnFiltradoDialogListener, GeneralDialog.OnGenarlDialogListener,
    GeneroListaDialog.OnGeneroListaListener, GeneroSimpleDialog.OnGeneroSimpleListener {

    private lateinit var listaUsuario: ArrayList<User>;
    private lateinit var adaptadoUsuariosAdapter: UsuariosAdapter
    private lateinit var binding: ActivityMainBinding
    private lateinit var adaptadorResultados: ArrayAdapter<Int>
    private lateinit var genero: String;
    private var resultados: Int = 0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        adaptadorResultados = ArrayAdapter(
            applicationContext,
            android.R.layout.simple_spinner_item, (1..100).toList()
        )
        adaptadorResultados.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerResultados.adapter = adaptadorResultados

        listaUsuario = ArrayList();
        adaptadoUsuariosAdapter = UsuariosAdapter(listaUsuario, this)

        binding.recyclerUsuarios.adapter = adaptadoUsuariosAdapter;
        binding.recyclerUsuarios.layoutManager =
            LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)

        // creo la peticion

    }

    fun getURLResponse(url: String): Unit {

        val peticion: JsonObjectRequest = JsonObjectRequest(url, {
            getUsers(it)
        }, {

        })
        //val peticion2: JsonObjectRequest = JsonObjectRequest(Method.GET,url,null,{},{})
        // lanzar la peticion
        Volley.newRequestQueue(applicationContext).add(peticion)
    }

    override fun onStart() {
        super.onStart()
        binding.spinnerResultados.onItemSelectedListener = this
        binding.spinnerGenero.onItemSelectedListener = this
    }

    fun getUsers(response: JSONObject): Unit {
        // crear clase modelo User
        // obtener una lista de todos los usuarios del JSON
        val results = response.getJSONArray("results")
        for (i in (0..results.length() - 1)) {
            val user = results.getJSONObject(i);
            val name = user.getJSONObject("name").getString("first")
            val last = user.getJSONObject("name").getString("last")
            val phone = user.getString("phone");
            val email = user.getString("email");
            val image = user.getJSONObject("picture").getString("medium")
            val country = user.getJSONObject("location").getString("country")

            val city = user.getJSONObject("location").getString("city")
            val usuario = User(name, last, email, phone, country, city, image)
            listaUsuario.add(
                usuario
            )
            adaptadoUsuariosAdapter.notifyItemInserted(listaUsuario.size - 1)
        }
        // nombre, apellido, telefono, pais, ciudad, codigo postal, mail

    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {


        when (parent!!.id) {
            binding.spinnerResultados.id -> {
                resultados = parent.adapter.getItem(position).toString().toInt()
                // peticion
            }

            binding.spinnerGenero.id -> {
                genero = parent.adapter.getItem(position).toString()
                // peticion
            }
        }

        listaUsuario.clear()
        adaptadoUsuariosAdapter.notifyDataSetChanged()

        getURLResponse("https://randomuser.me/api/?results=${resultados}&gender=${genero.toLowerCase()}")
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {

    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        // traer el menu -> xml
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_reset -> {
                getURLResponse("https://randomuser.me/api/?results=50");
                binding.spinnerResultados.setSelection(49)
                binding.spinnerGenero.setSelection(0)
            }

            R.id.menu_version -> {
                val versionDialog: VersionDialog = VersionDialog();
                versionDialog.show(supportFragmentManager, null)
            }

            R.id.menu_filtro -> {
                val filtroDialog = GeneralDialog()
                filtroDialog.show(supportFragmentManager, null)
            }

            R.id.menu_nac->{
                val nacioDialog = NacionalidadDialog()
                nacioDialog.show(supportFragmentManager,null)
            }
        }
        return true
    }

    override fun onGeneroSelected(genero: String) {
        Snackbar.make(binding.root, "Seleccionado ${genero}", Snackbar.LENGTH_SHORT)
            .show()
    }

    override fun onGeneralSelected(filtro: String) {
        lateinit var dialog: DialogFragment
        when (filtro) {
            "genero" -> {
                dialog = GeneroSimpleDialog()
            }

            "numero" -> {

            }
        }
        dialog.show(supportFragmentManager, null)
    }

    override fun onGeneroListaSelected(genero: String) {

    }

    override fun onGeneroSimpleSelected(genero: String?) {
        Snackbar.make(binding.root,genero?:"sin seleccion",Snackbar.LENGTH_SHORT).show()
    }
}