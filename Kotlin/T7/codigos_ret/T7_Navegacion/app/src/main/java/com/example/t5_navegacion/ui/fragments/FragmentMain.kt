package com.example.t5_navegacion.ui.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.t5_navegacion.databinding.FragmentLoginBinding
import com.example.t5_navegacion.databinding.FragmentMainBinding
import com.example.t5_navegacion.databinding.FragmentSignupBinding
import com.example.t5_navegacion.model.Producto
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

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
    private lateinit var uid: String;
    private var contador: Int = 0;

    override fun onAttach(context: Context) {
        super.onAttach(context)
        database = FirebaseDatabase
            .getInstance("https://proyectoret-bmh2023-default-rtdb.firebaseio.com/")
        uid = arguments?.getString("uid")!!
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
            database.getReference("usuarios").child(uid).child("productos")
                .child(contador.toString()).setValue(
                Producto(
                    binding.editNodo.text.toString(),
                    binding.editValor.text.toString().toInt()
                )
            )
            contador++
        }
        binding.botonConsulta.setOnClickListener {
            database.getReference("consultas").child("hoja1")
                .addValueEventListener(object : ValueEventListener{
                    override fun onDataChange(snapshot: DataSnapshot) {
                        snapshot.children.forEach {
                            Log.v("datos", it.value.toString())
                        }
                    }

                    override fun onCancelled(error: DatabaseError) {
                    }

                })
        }
    }

    override fun onDetach() {
        super.onDetach()
    }
}