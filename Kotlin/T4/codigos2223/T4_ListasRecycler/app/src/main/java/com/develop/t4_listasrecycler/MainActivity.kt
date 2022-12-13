package com.develop.t4_listasrecycler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.develop.t4_listasrecycler.adapters.AdaptadorUsuarios
import com.develop.t4_listasrecycler.databinding.ActivityMainBinding
import com.develop.t4_listasrecycler.model.Usuario
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(), AdaptadorUsuarios.OnRecyclerUsuarioListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var listaUsuarios: ArrayList<Usuario>
    private lateinit var listaUsuariosFiltrada: ArrayList<Usuario>
    private lateinit var adaptadorUsuarios: AdaptadorUsuarios;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        instancias()
        configurarRecycler()
        acciones()
    }

    private fun acciones() {

    }

    private fun configurarRecycler() {
        // 2. poner un adaptador dentro del recycler
        binding.listaRecycler.adapter = adaptadorUsuarios;
        // 3. poner un layout dentro del recycler --> Linear Grid
        binding.listaRecycler.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        //binding.listaRecycler.layoutManager = GridLayoutManager(this,2)

    }

    private fun instancias() {
        //1- tener una lista de datos a representar
        listaUsuarios = ArrayList()
        listaUsuarios.add(Usuario("Borja", "Martin",1234,R.drawable.male))
        listaUsuarios.add(Usuario("Celia", "Martin",2345,R.drawable.female))
        listaUsuarios.add(Usuario("Julia", "Gomez",3456,R.drawable.female))
        listaUsuarios.add(Usuario("Carlos", "Frances",4567,R.drawable.male))
        listaUsuarios.add(Usuario("Carlos", "Frances",4567,R.drawable.male))
        listaUsuarios.add(Usuario("Carlos", "Frances",4567,R.drawable.male))
        listaUsuarios.add(Usuario("Carlos", "Frances",4567,R.drawable.male))
        listaUsuarios.add(Usuario("Carlos", "Frances",4567,R.drawable.male))
        listaUsuarios.add(Usuario("Carlos", "Frances",4567,R.drawable.male))
        listaUsuarios.add(Usuario("Carlos", "Frances",4567,R.drawable.male))
        listaUsuarios.add(Usuario("Carlos", "Frances",4567,R.drawable.male))
        adaptadorUsuarios = AdaptadorUsuarios(listaUsuarios, this);
    }

    override fun onUsuarioSelected(usuario: Usuario) {
        Snackbar.make(binding.root,
            "Comunicado ${usuario.nombre}", Snackbar.LENGTH_SHORT).show()
    }

    override fun onUsuarioSelected(usuario: Usuario, posicion: Int) {
        Snackbar.make(binding.root,
            "Comunicado ${usuario.nombre} ${posicion}", Snackbar.LENGTH_SHORT).show()
    }
}