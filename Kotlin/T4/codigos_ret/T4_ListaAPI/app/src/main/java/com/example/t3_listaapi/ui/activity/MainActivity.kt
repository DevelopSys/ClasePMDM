package com.example.t3_listaapi.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.t3_listaapi.R
import com.example.t3_listaapi.adapter.UsuariosAdapter
import com.example.t3_listaapi.databinding.ActivityMainBinding
import com.example.t3_listaapi.model.Direccion
import com.example.t3_listaapi.model.Usuario
import com.example.t3_listaapi.ui.dialog.CreditosDialog
import com.example.t3_listaapi.ui.dialog.GeneralDialog
import com.example.t3_listaapi.ui.dialog.GeneroDialog
import com.example.t3_listaapi.ui.dialog.NumeroDialog
import org.json.JSONObject

class MainActivity : AppCompatActivity(), OnItemSelectedListener,
    GeneroDialog.OnGeneroDialogListener, GeneralDialog.OnGeneralDialogoListener,
NumeroDialog.OnNumeroDialogListener{

    private lateinit var listaUsuario: ArrayList<Usuario>;
    private lateinit var adaptadoUsuariosAdapter: UsuariosAdapter
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapterResultados: ArrayAdapter<Int>
    private var numeroSeleccionado: Int = 0;
    private lateinit var generoSeleccionado: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        adapterResultados = ArrayAdapter(
            applicationContext,
            android.R.layout.simple_spinner_item, (1..100).toList()
        )
        binding.spinnerResultados.adapter = adapterResultados
        adapterResultados.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line)
        listaUsuario = ArrayList();
        adaptadoUsuariosAdapter = UsuariosAdapter(listaUsuario, this)
        binding.recyclerUsuarios.adapter = adaptadoUsuariosAdapter;
        binding.recyclerUsuarios.layoutManager =
            LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)


        binding.spinnerResultados.onItemSelectedListener = this
        binding.spinnerGenero.onItemSelectedListener = this
    }

    fun addPetion(url: String): Unit {

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

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.menu_reset -> {
                // resetea la peticion ->
                /*numeroSeleccionado=50
                generoSeleccionado="All"
                val url = "https://randomuser.me/api/?gender=${generoSeleccionado.toLowerCase()}&results=${numeroSeleccionado}"
                addPetion(url)*/
                binding.spinnerGenero.setSelection(0)
                binding.spinnerResultados.setSelection(49)
            }

            R.id.menu_filtros -> {
                //val dialogo = GeneroDialog()
                //dialogo.show(supportFragmentManager,null)
                val dialogo = GeneralDialog()
                dialogo.show(supportFragmentManager, null)
            }

            R.id.menu_creditos -> {
                val dialogo = CreditosDialog();
                dialogo.show(supportFragmentManager, null)
            }
        }


        return super.onOptionsItemSelected(item)
    }

    fun precesarResponse(response: JSONObject): Unit {

        adaptadoUsuariosAdapter.vaciarLista()
        val results = response.getJSONArray("results")
        for (i in 0..results.length() - 1) {
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
            listaUsuario.add(
                Usuario(
                    nombre, apellido,
                    Direccion(pais, ciudad), telefono, mail, imagen
                )
            )
            //adaptadoUsuariosAdapter.notifyDataSetChanged()
            adaptadoUsuariosAdapter.notifyItemInserted(listaUsuario.size - 1)
        }
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        // saber que spinner esta seleccionado
        when (parent!!.id) {
            binding.spinnerResultados.id -> {
                numeroSeleccionado = parent.adapter.getItem(position).toString().toInt()
            }

            binding.spinnerGenero.id -> {
                generoSeleccionado = parent.adapter.getItem(position).toString()
            }
        }
        val url =
            "https://randomuser.me/api/?gender=${generoSeleccionado.toLowerCase()}&results=${numeroSeleccionado}"
        addPetion(url)
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        TODO("Not yet implemented")
    }

    override fun onGeneroSelected(gender: String) {
        Toast.makeText(
            this, "El genero cominciado es ${gender}",
            Toast.LENGTH_SHORT
        ).show()
    }

    override fun onFiltroSelected(tipo: String) {
        var dialogo: DialogFragment? = null
        when (tipo) {
            "numero" -> {
                dialogo = NumeroDialog()
            }

            "genero" -> {
                dialogo = GeneroDialog()
            }
        }
        dialogo?.show(supportFragmentManager, null)
    }

    override fun onNumeroSelected(numero: Int) {
        // filtado por numero
    }

}