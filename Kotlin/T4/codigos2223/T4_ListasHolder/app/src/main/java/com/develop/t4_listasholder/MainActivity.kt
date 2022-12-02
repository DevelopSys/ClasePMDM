package com.develop.t4_listasholder

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.develop.t4_listasholder.databinding.ActivityMainBinding
import com.develop.t4_listasholder.model.Usuario

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var listaUsuarios: ArrayList<Usuario>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        instancias();


    }

    private fun instancias() {

        listaUsuarios = ArrayList();
        listaUsuarios.add(Usuario("Borja","Martin","correo@retamar.es",38))
        listaUsuarios.add(Usuario("Jose","Martin","correo@retamar.es",34))
        listaUsuarios.add(Usuario("Pedro","Martin","correo@retamar.es",32))
        listaUsuarios.add(Usuario("Claudia","Martin","correo@retamar.es",24))
        listaUsuarios.add(Usuario("Maria","Martin","correo@retamar.es",36))
        listaUsuarios.add(Usuario("Celia","Martin","correo@retamar.es",32))
    }
}