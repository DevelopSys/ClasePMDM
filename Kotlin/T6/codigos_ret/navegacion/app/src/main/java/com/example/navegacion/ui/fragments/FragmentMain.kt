package com.example.navegacion.ui.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.navegacion.databinding.FragmentMainBinding
import com.example.navegacion.model.Usuario
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class FragmentMain : Fragment() {

    private lateinit var binding: FragmentMainBinding
    private lateinit var database: FirebaseDatabase
    private lateinit var auth: FirebaseAuth

    override fun onAttach(context: Context) {
        super.onAttach(context)
        database =
            FirebaseDatabase.getInstance("https://comprasret-dae09-default-rtdb.europe-west1.firebasedatabase.app/")
        auth = FirebaseAuth.getInstance()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        binding.btnEscribir.setOnClickListener {

            val usuario = Usuario("Borja1", "borja@gmail.com", "1234")
            val referencia = database.reference.child("usuarios")
                .child(auth.currentUser!!.uid)
            referencia.setValue(usuario)
        }
        binding.btnLeer.setOnClickListener {
            /*database.reference.child("version")
                .get().addOnCompleteListener {
                    if (it.isSuccessful){
                        Log.v("lectura","lectura completa")
                        Log.v("lectura",it.result.value.toString())
                    }
                }*/
            database.reference.child("usuarios")
                .addListenerForSingleValueEvent(object : ValueEventListener {
                    override fun onDataChange(snapshot: DataSnapshot) {
                        for (i in snapshot.children) {

                            val usuario = i.getValue(Usuario::class.java)

                            Log.v("lectura", usuario!!.nombre.toString())
                            Log.v("lectura", usuario!!.correo.toString())
                            Log.v("lectura", usuario!!.pass.toString())
                        }
                    }

                    override fun onCancelled(error: DatabaseError) {

                    }

                })
        }
    }
}