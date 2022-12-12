package com.develop.t4_listasrecycler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.develop.t4_listasrecycler.databinding.ActivityMainBinding
import com.develop.t4_listasrecycler.model.Usuario

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var listaUsuarios: ArrayList<Usuario>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        instancias()
        // poner un adaptador dentro del recycler

        // poner un layout dentro del recycler --> Linear Grid

        binding.listaRecycler
    }

    private fun instancias() {
        //1- tener una lista de datos a representar
        listaUsuarios = ArrayList()
        listaUsuarios.add(Usuario("Borja", "Martin",1234,R.drawable.male))
        listaUsuarios.add(Usuario("Celia", "Martin",2345,R.drawable.female))
        listaUsuarios.add(Usuario("Julia", "Gomez",3456,R.drawable.female))
        listaUsuarios.add(Usuario("Carlos", "Frances",4567,R.drawable.male))
    }
}