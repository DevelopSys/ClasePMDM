package com.example.t5_navegacion.ui.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.t5_navegacion.databinding.FragmentLoginBinding
import com.example.t5_navegacion.databinding.FragmentMainBinding
import com.example.t5_navegacion.databinding.FragmentSignupBinding
import com.google.firebase.database.FirebaseDatabase

class FragmentMain : Fragment() {

    /*
    * Borrar todos los usuarios registrados
    * Cuando un usuario se registra, se guarda en base de datos sus datos
    * ademas tendrá un nodo tutorial: true
    * la primera vez que el usuario inicie sesion
    * el atributo cambia a false
    * */

    private lateinit var binding: FragmentMainBinding
    private lateinit var database: FirebaseDatabase

    override fun onAttach(context: Context) {
        super.onAttach(context)
        database = FirebaseDatabase
            .getInstance("https://proyectoret-bmh2023-default-rtdb.firebaseio.com/")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.botonAdd.setOnClickListener {
            database.getReference("usuarios").child(binding.editNodo.text.toString())
                .setValue(binding.editValor.text.toString())
        }
    }

    override fun onDetach() {
        super.onDetach()
    }
}